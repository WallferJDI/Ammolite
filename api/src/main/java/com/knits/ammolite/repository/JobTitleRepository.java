package com.knits.ammolite.repository;

import com.knits.ammolite.model.employee.JobTitle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobTitleRepository extends JpaRepository<JobTitle, Long> {
}

