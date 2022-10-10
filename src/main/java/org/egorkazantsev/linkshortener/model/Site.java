package org.egorkazantsev.linkshortener.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@ToString(callSuper = true)
@Entity
@Table(name = "sites")
public class Site extends BaseEntity{

    @Column(name = "domain")
    private String domain;

    @Column(name = "created_count")
    private Long createdCount = 0L;
}
