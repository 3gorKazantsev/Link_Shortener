package org.egorkazantsev.linkshortener.repository;

import org.egorkazantsev.linkshortener.model.Link;
import org.egorkazantsev.linkshortener.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LinkRepo extends JpaRepository<Link, Long> {

    List<Link> findAllByUser(User user);
}
