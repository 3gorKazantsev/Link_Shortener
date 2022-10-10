package org.egorkazantsev.linkshortener.service;

import org.egorkazantsev.linkshortener.model.Site;

import java.util.List;

public interface StatsService {

    String getGraph();

    List<Site> getTop20Sites();
}
