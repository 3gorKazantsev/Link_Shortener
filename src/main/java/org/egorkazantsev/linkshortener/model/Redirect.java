package org.egorkazantsev.linkshortener.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "redirects")
public class Redirect extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "link_id")
    private Link link;
}
