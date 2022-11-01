package com.knits.ammolite.repository;

import com.knits.ammolite.model.employee.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}

