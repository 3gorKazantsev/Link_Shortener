package org.egorkazantsev.linkshortener.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString(callSuper = true)
@Entity
@Table(name = "links")
public class Link extends BaseEntity{

    @Column(name = "full_url")
    private String fullUrl;

    @Column(name = "short_name")
    private String shortName;

    @Column(name = "short_url")
    private String shortUrl;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
