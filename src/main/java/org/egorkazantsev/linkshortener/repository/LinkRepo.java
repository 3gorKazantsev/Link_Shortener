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

    Link findByShortUrl(String shortUrl);

    Link findByShortName(String shortName);

    @Query(value = "select l.id as \"id\", l.created_at as \"createdAt\", l.full_url as \"fullUrl\", l.short_url as \"shortUrl\", count(all r) as \"redirectCount\" from redirects r right join links l on r.link_id = l.id where l.short_url = :shortUrl group by l.id;",
            nativeQuery = true)
    LinkInfoProjection getLinkInfoByShortUrl(@Param("shortUrl") String shortUrl);
}
