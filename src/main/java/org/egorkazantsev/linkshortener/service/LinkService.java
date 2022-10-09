package org.egorkazantsev.linkshortener.service;

import org.egorkazantsev.linkshortener.model.Link;
import org.egorkazantsev.linkshortener.model.User;

import java.util.List;

public interface LinkService {

    Link createShortLink(String fullLink);

    List<Link> getAllLinksByUser(User user);

    Link getLinkInfo(String shortLink);

    void deleteLink(String shortLink);

    String getFullLinkByShortName(String shortLink);
}
