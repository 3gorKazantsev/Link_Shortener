package org.egorkazantsev.linkshortener.controller;

import org.egorkazantsev.linkshortener.model.Link;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/link")
public class UserLinkController {

    @PostMapping("/{long_link}")
    public Link createShortLink(
            @PathVariable("long_link") String longLink
    ) {
        return null;
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
