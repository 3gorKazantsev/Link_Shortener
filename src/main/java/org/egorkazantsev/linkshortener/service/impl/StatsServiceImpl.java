package org.egorkazantsev.linkshortener.service.impl;

import org.egorkazantsev.linkshortener.model.Link;
import org.egorkazantsev.linkshortener.service.StatsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatsServiceImpl implements StatsService {

    @Override
    public String getGraph() {
        return null;
    }

    @Override
    public List<Link> getTop20Sites() {
        return null;
    }
}
