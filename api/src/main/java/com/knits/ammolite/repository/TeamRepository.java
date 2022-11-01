package com.knits.ammolite.repository;

import com.knits.ammolite.model.organization.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeamRepository extends JpaRepository<Team,Long> {
    Optional<Team> findByName(String name);
    Boolean existsByName(String name);
}
