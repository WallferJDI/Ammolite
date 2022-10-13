package com.knits.ammolite.repository;

import com.knits.ammolite.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team,Long> {
}
