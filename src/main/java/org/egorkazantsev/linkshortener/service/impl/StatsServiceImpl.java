package org.egorkazantsev.linkshortener.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.egorkazantsev.linkshortener.model.Site;
import org.egorkazantsev.linkshortener.repository.SiteRepo;
import org.egorkazantsev.linkshortener.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class StatsServiceImpl implements StatsService {

    private final SiteRepo siteRepo;

    @Autowired
    public StatsServiceImpl(SiteRepo siteRepo) {
        this.siteRepo = siteRepo;
    }

    @Override
    public String getGraph() {
        return null;
    }

    @Override
    public List<Site> getTop20Sites() {
        List<Site> sites = siteRepo.findTop20ByOrderByCreatedCountDesc();

        log.info("IN getTop20Sites - {} sites returned", sites.size());

        return sites;
    }
}