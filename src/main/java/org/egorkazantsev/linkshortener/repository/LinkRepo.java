package org.egorkazantsev.linkshortener.repository;

import org.egorkazantsev.linkshortener.model.Link;
import org.egorkazantsev.linkshortener.model.User;
import org.egorkazantsev.linkshortener.model.projection.LinkInfoProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LinkRepo extends JpaRepository<Link, Long> {

    List<Link> findAllByUser(User user);

    Link findByShortLink(String shortLink);

    Link findByShortName(String shortName);

    @Query(value = "select l.id as \"id\", l.created_at as \"createdAt\", l.full_link as \"fullLink\", l.short_link as \"shortLink\", count(all r) as \"redirectCount\" from redirects r right join links l on r.link_id = l.id where l.short_link = :shortLink group by l.id;",
            nativeQuery = true)
    LinkInfoProjection getLinkInfoByShortLink(@Param("shortLink") String shortLink);
}
