package org.egorkazantsev.linkshortener.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString(callSuper = true)
@Entity
@Table(name = "redirects")
public class Redirect extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "link_id")
    private Link link;
}
