package org.egorkazantsev.linkshortener.controller;

import org.egorkazantsev.linkshortener.model.Link;
import org.egorkazantsev.linkshortener.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/link")
public class UserLinkController {

    private final LinkService linkService;

    @Autowired
    public UserLinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping
    public Link createShortLink(@RequestBody String fullLink) {
        return linkService.createShortLink(fullLink);
    }

    @GetMapping
    public List<Link> getAllUserLinks() {
        return linkService.getAllUserLinks();
    }

    @GetMapping("/info")
    public Link getLinkInfoByName(@RequestBody String shortLink) {
        return null;
    }

    @DeleteMapping
    public void deleteLinkByName(@RequestBody String shortLink) {
        linkService.deleteLink(shortLink);
    }
}
