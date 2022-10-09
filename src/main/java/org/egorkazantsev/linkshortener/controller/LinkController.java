package org.egorkazantsev.linkshortener.controller;

import org.egorkazantsev.linkshortener.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping
public class LinkController {

    private final LinkService linkService;

    @Autowired
    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @GetMapping("/{short_name}")
    public RedirectView redirectShorLink(@PathVariable("short_name") String shortName) {
        String url = linkService.getFullLinkAndPrepareRedirectByShortName(shortName);

        return new RedirectView(url);
    }
}
