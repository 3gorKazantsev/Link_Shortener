package org.egorkazantsev.linkshortener.service;

import org.egorkazantsev.linkshortener.model.Link;
import org.egorkazantsev.linkshortener.model.projection.LinkInfoProjection;

import java.util.List;

public interface LinkService {

    Link createShortLink(String fullLink);

    List<Link> getAllUserLinks();

    LinkInfoProjection getLinkInfo(String shortLink);

    void deleteLink(String shortLink);

    String getFullLinkAndPrepareRedirectByShortName(String shortName);
}
