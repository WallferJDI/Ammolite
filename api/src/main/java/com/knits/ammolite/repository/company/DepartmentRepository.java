package com.knits.ammolite.repository.company;

import com.knits.ammolite.model.company.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}

