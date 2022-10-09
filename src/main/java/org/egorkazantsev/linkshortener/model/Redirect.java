package org.egorkazantsev.linkshortener.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@Entity
@Table(name = "redirects")
public class Redirect extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "link_id")
    private Link link;
}
