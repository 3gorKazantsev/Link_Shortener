package org.egorkazantsev.linkshortener.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/api")
public class LinkController {

    @GetMapping("/{short_link}")
    public ModelAndView redirectByName(
            @PathVariable("short_link") String shortLink
    ) {
        return null;
    }
}
