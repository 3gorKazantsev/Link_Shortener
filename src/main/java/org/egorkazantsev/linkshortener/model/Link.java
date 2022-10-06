package org.egorkazantsev.linkshortener.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "links")
public class Link extends BaseEntity{

    @Column(name = "full_link")
    private String fullLink;

    @Column(name = "short_link")
    private String shortLink;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
