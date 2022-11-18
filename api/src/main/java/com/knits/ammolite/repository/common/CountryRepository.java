package com.knits.ammolite.repository.common;

import com.knits.ammolite.model.common.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country,Long> {

    Optional<Country> findByName(String name);
    Boolean existsByName(String name);
}
