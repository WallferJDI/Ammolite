package com.knits.ammolite.repository;

import com.knits.ammolite.model.employee.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderRepository extends JpaRepository<Gender, Long> {
}

