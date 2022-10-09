package org.egorkazantsev.linkshortener.repository;

import org.egorkazantsev.linkshortener.model.Redirect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedirectRepo extends JpaRepository<Redirect, Long> {
}
