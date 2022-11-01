package com.knits.ammolite.repository;

import com.knits.ammolite.model.employee.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}

