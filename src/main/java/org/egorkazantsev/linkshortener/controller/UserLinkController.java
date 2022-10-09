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

    @PostMapping("/{full_link}")
    public Link createShortLink(@PathVariable("full_link") String fullLink) {
        return linkService.createShortLink(fullLink);
    }

    @GetMapping
    public List<Link> getAllUserLinks() {
        return null;
    }

    @GetMapping("/info/{short_link}")
    public Link getLinkInfoByName(
            @PathVariable("short_link") String shortLink
    ) {
        return null;
    }

    @DeleteMapping("/{short_link}")
    public void deleteLinkByName(
            @PathVariable("short_link") String shortLink
    ) {

    }
}
