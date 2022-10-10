package org.egorkazantsev.linkshortener.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.egorkazantsev.linkshortener.model.Link;
import org.egorkazantsev.linkshortener.model.Redirect;
import org.egorkazantsev.linkshortener.model.Site;
import org.egorkazantsev.linkshortener.model.User;
import org.egorkazantsev.linkshortener.model.projection.LinkInfoProjection;
import org.egorkazantsev.linkshortener.repository.LinkRepo;
import org.egorkazantsev.linkshortener.repository.RedirectRepo;
import org.egorkazantsev.linkshortener.repository.SiteRepo;
import org.egorkazantsev.linkshortener.repository.UserRepo;
import org.egorkazantsev.linkshortener.service.LinkService;
import org.egorkazantsev.linkshortener.util.ShortLinkUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Service
@Slf4j
public class LinkServiceImpl implements LinkService {

    private final LinkRepo linkRepo;
    private final UserRepo userRepo;
    private final RedirectRepo redirectRepo;
    private final SiteRepo siteRepo;
    private final ShortLinkUtil shortLinkUtil;

    @Autowired
    public LinkServiceImpl(LinkRepo linkRepo, UserRepo userRepo, RedirectRepo redirectRepo, SiteRepo siteRepo, ShortLinkUtil shortLinkUtil) {
        this.linkRepo = linkRepo;
        this.userRepo = userRepo;
        this.redirectRepo = redirectRepo;
        this.siteRepo = siteRepo;
        this.shortLinkUtil = shortLinkUtil;
    }

    @Override
    public Link createShortLink(String fullLink) {
        // TODO some operation to get currently authorized user
        User currentUser = userRepo.findByUsername("admin");

        // TODO if fullLink is an absolute URL -> OK : else normalize to absolute URL (add schema)

        // full link's domain
        String domain = "";

        try {
            // attempt to get a domain by full link
            URI uri = new URI(fullLink);
            domain = uri.getHost();
            domain = domain.startsWith("www.") ? domain.substring(4) : domain;
        } catch (URISyntaxException e) {
            e.getMessage();
        }

        // if domain name is not empty
        if (!domain.equals("")) {
            // if domain exists in DB - get it else create new
            Site site = siteRepo.findByDomain(domain) != null ?
                    siteRepo.findByDomain(domain) : new Site();

            // setting site properties
            site.setDomain(domain);
            site.setCreatedCount(site.getCreatedCount() + 1);

            siteRepo.save(site);

            log.info("IN createShortLink - Site: {} - successfully created/updated", site);

            // creating and saving empty link to access id
            Link link = new Link();
            linkRepo.save(link);

            // creating short link via converting id to base62
            String shortName = shortLinkUtil.mapBase10ToBase62(link.getId());
            String shortLink = shortLinkUtil.createShortLink(shortName);

            // setting link properties
            link.setFullLink(fullLink);
            link.setShortName(shortName);
            link.setUser(currentUser);
            link.setShortLink(shortLink);

            linkRepo.save(link);

            log.info("IN createShortLink - Link: {} successfully created", link);

            return link;
        } else {
            log.warn("IN createShortLink - incorrect full link");

            return null;
        }
    }

    @Override
    public List<Link> getAllUserLinks() {
        // TODO some operation to get currently authorized user
        User currentUser = userRepo.findByUsername("admin");

        List<Link> userLinks = linkRepo.findAllByUser(currentUser);

        log.info("IN getAllUserLinks - {} User's Links found", userLinks.size());

        return userLinks;
    }

    @Override
    public LinkInfoProjection getLinkInfo(String shortLink) {
        // TODO some operation to check the owner of link
        User currentUser = userRepo.findByUsername("admin");

        LinkInfoProjection linkInfo = linkRepo.getLinkInfoByShortLink(shortLink);

        log.info("IN getLinkInfo - LinkInfoDto: {} successfully returned", linkInfo);

        return linkInfo;
    }

    @Override
    public void deleteLink(String shortLink) {
        // TODO some operation to check the owner of link
        User currentUser = userRepo.findByUsername("admin");

        Link linkToDelete = linkRepo.findByShortLink(shortLink);

        linkRepo.delete(linkToDelete);

        log.info("IN deleteLink - Link: {} successfully deleted", linkToDelete);
    }

    @Override
    public String getFullLinkAndPrepareRedirectByShortName(String shortName) {
        // finding link by its short name
        Link link = linkRepo.findByShortName(shortName);

        // creating and saving redirect for given short link
        Redirect redirect = new Redirect();
        redirect.setLink(link);
        redirectRepo.save(redirect);

        log.info("IN prepareRedirectByShortLink - Redirect: {} successfully saved", redirect);

        log.info("IN prepareRedirectByShortLink - Link's full link: {} successfully returned", link);

        return link.getFullLink();
    }
}
