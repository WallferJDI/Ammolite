package com.knits.ammolite.repository;

import com.knits.ammolite.model.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderRepository extends JpaRepository<Gender, Long> {
}

