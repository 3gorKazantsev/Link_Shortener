package org.egorkazantsev.linkshortener.service;

import org.egorkazantsev.linkshortener.model.Link;
import org.egorkazantsev.linkshortener.model.projection.LinkInfoProjection;

import java.util.List;

public interface LinkService {

    Link createShortLink(String fullLink);

    List<Link> getAllUserLinks();

    LinkInfoProjection getLinkInfo(String shortUrl);

    void deleteLink(String shortUrl);

    String getFullUrlAndPrepareRedirectByShortName(String shortName);
}
