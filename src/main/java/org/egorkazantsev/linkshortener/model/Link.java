package org.egorkazantsev.linkshortener.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
@Entity
@Table(name = "links")
public class Link extends BaseEntity{

    @Column(name = "full_url")
    private String fullUrl;

    @Column(name = "short_name")
    private String shortName;

    @Column(name = "short_url")
    private String shortUrl;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "link", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Collection<Redirect> redirects;

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + getId() + ", " +
                "createdAt = " + getCreatedAt() + ", " +
                "fullUrl = " + getFullUrl() + ", " +
                "shortName = " + getShortName() + ", " +
                "shortUrl = " + getShortUrl() + ", " +
                "user = " + getUser() + ")";
    }
}
