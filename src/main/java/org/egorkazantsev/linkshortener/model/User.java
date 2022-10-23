package org.egorkazantsev.linkshortener.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    // TODO make column uniq
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "is_active")
    private boolean isActive;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}
    )
    private List<Role> roles;

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + getId() + ", " +
                "createdAt = " + getCreatedAt() + ", " +
                "username = " + getUsername() + ", " +
                "password = " + getPassword() + ", " +
                "firstName = " + getFirstName() + ", " +
                "lastName = " + getLastName() + ")";
    }
}
