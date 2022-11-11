package com.knits.ammolite.repository.security;

import com.knits.ammolite.model.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}

