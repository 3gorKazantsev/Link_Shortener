package org.egorkazantsev.linkshortener.dto;

import lombok.Data;

import java.util.Date;

@Data
public class LinkInfoDto {

    private Long id;
    private Date createdAt;
    private String fullLink;
    private String shortLink;

}
