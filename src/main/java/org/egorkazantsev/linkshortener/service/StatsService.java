package org.egorkazantsev.linkshortener.service;

import org.egorkazantsev.linkshortener.model.Link;

import java.util.List;

public interface StatsService {

    String getGraph();

    List<Link> getTop20Sites();
}
