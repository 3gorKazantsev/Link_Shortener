package org.egorkazantsev.linkshortener.repository;

import org.egorkazantsev.linkshortener.model.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SiteRepo extends JpaRepository<Site, Long> {

    Site findByDomain(String domain);

    List<Site> findTop20ByOrderByCreatedCountDesc();
}
