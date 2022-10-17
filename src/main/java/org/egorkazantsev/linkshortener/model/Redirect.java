package org.egorkazantsev.linkshortener.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @ManyToOne
    private Link link;
}
