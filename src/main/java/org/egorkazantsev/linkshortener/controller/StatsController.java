package org.egorkazantsev.linkshortener.controller;

import org.egorkazantsev.linkshortener.model.Site;
import org.egorkazantsev.linkshortener.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/stats")
public class StatsController {

    private final StatsService statsService;

    @Autowired
    public StatsController(StatsService statsService) {
        this.statsService = statsService;
    }

    @GetMapping
    public String getGraph() {
        return null;
    }

    @GetMapping("/top20")
    public List<Site> getTop20Sites() {
        return statsService.getTop20Sites();
    }
}
