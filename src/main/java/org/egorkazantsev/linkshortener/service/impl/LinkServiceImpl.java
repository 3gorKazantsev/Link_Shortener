package org.egorkazantsev.linkshortener.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.egorkazantsev.linkshortener.dto.LinkInfoDto;
import org.egorkazantsev.linkshortener.model.Link;
import org.egorkazantsev.linkshortener.model.Redirect;
import org.egorkazantsev.linkshortener.model.User;
import org.egorkazantsev.linkshortener.repository.LinkRepo;
import org.egorkazantsev.linkshortener.repository.RedirectRepo;
import org.egorkazantsev.linkshortener.repository.UserRepo;
import org.egorkazantsev.linkshortener.service.LinkService;
import org.egorkazantsev.linkshortener.util.ShortLinkUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class LinkServiceImpl implements LinkService {

    private final LinkRepo linkRepo;
    private final UserRepo userRepo;
    private final RedirectRepo redirectRepo;
    private final ShortLinkUtil shortLinkUtil;

    @Autowired
    public LinkServiceImpl(LinkRepo linkRepo, UserRepo userRepo, RedirectRepo redirectRepo, ShortLinkUtil shortLinkUtil) {
        this.linkRepo = linkRepo;
        this.userRepo = userRepo;
        this.redirectRepo = redirectRepo;
        this.shortLinkUtil = shortLinkUtil;
    }

    @Override
    public Link createShortLink(String fullLink) {
        // TODO some operation to get currently authorized user
        User currentUser = userRepo.findByUsername("admin");

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

        log.info("IN createShortLink - link: {} successfully created", link);

        return link;
    }

    @Override
    public List<Link> getAllUserLinks() {
        // TODO some operation to get currently authorized user
        User currentUser = userRepo.findByUsername("admin");

        List<Link> userLinks = linkRepo.findAllByUser(currentUser);

        log.info("IN getAllUserLinks - {} user's links found", userLinks.size());

        return userLinks;
    }

    @Override
    public LinkInfoDto getLinkInfo(String shortLink) {


        return null;
    }

    @Override
    public void deleteLink(String shortLink) {
        // TODO some operation to check the owner of link
        User currentUser = userRepo.findByUsername("admin");

        Link linkToDelete = linkRepo.findByShortLink(shortLink);

        linkRepo.delete(linkToDelete);

        log.info("IN deleteLink - link: {} successfully deleted", linkToDelete);
    }

    @Override
    public String getFullLinkAndPrepareRedirectByShortName(String shortName) {
        // finding link by its short name
        Link link = linkRepo.findByShortName(shortName);

        // creating and saving redirect for given short link
        Redirect redirect = new Redirect();
        redirect.setLink(link);
        redirectRepo.save(redirect);

        log.info("IN prepareRedirectByShortLink - redirect: {} successfully saved", redirect);

        log.info("IN prepareRedirectByShortLink - link's full link: {} successfully returned", link);

        return link.getFullLink();
    }
}
