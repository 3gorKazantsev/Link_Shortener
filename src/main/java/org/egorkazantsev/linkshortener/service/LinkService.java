package org.egorkazantsev.linkshortener.service;

import org.egorkazantsev.linkshortener.dto.LinkInfoDto;
import org.egorkazantsev.linkshortener.model.Link;

import java.util.List;

public interface LinkService {

    Link createShortLink(String fullLink);

    List<Link> getAllUserLinks();

    LinkInfoDto getLinkInfo(String shortLink);

    void deleteLink(String shortLink);

    String getFullLinkAndPrepareRedirectByShortName(String shortName);
}
