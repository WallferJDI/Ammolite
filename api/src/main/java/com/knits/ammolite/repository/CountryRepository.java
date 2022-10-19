package com.knits.ammolite.repository;

import com.knits.ammolite.model.organization.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CountryRepository  extends JpaRepository<Country,Long> {

    Optional<Country> findByName(String name);
}
