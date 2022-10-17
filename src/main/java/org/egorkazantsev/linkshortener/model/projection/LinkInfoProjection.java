package org.egorkazantsev.linkshortener.model.projection;

import java.util.Date;

// TODO replace with DTO class
public interface LinkInfoProjection {

    Long getId();
    Date getCreatedAt();
    String getFullUrl();
    String getShortUrl();
    Integer getRedirectCount();
}
