package com.knits.ammolite.repository;

import com.knits.ammolite.model.employee.Office;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficeRepository extends JpaRepository<Office, Long> {
}

