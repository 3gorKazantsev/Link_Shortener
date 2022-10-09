package org.egorkazantsev.linkshortener.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.egorkazantsev.linkshortener.model.Link;
import org.egorkazantsev.linkshortener.model.User;
import org.egorkazantsev.linkshortener.repository.LinkRepo;
import org.egorkazantsev.linkshortener.repository.UserRepo;
import org.egorkazantsev.linkshortener.service.LinkService;
import org.egorkazantsev.linkshortener.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class LinkServiceImpl implements LinkService {

    private final LinkRepo linkRepo;
    private final UserRepo userRepo;

    @Autowired
    public LinkServiceImpl(LinkRepo linkRepo, UserRepo userRepo) {
        this.linkRepo = linkRepo;
        this.userRepo = userRepo;
    }

    @Override
    public Link createShortLink(String fullLink) {
        // TODO some operation to get currently authorized user
        User currentUser = userRepo.findByUsername("admin");

        // creating link
        Link link = new Link();
        linkRepo.save(link);

        // setting link properties
        link.setFullLink(fullLink);
        link.setUser(currentUser);
        // creating short link using via converting id to base62
        link.setShortLink(Util.mapBase10ToBase62(link.getId()));
        linkRepo.save(link);

        log.info("IN createShortLink - link: {} successfully created", link);

        return link;
    }

    @Override
    public List<Link> getAllLinksByUser(User user) {
        return null;
    }

    @Override
    public Link getLinkInfo(String shortLink) {
        return null;
    }

    @Override
    public void deleteLink(String shortLink) {

    }

    @Override
    public String getFullLinkByShortName(String shortLink) {
        return null;
    }
}
