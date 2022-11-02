package com.knits.ammolite.repository;

import com.knits.ammolite.model.company.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GroupRepository extends JpaRepository<Group,Long> {

    Optional<Group> findByName(String name);
    Boolean existsByName(String name);
}
