package com.knits.ammolite.repository.common;

import com.knits.ammolite.model.common.Organization;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    Page<Organization> findAll(Specification<Organization> specification, Pageable pageable);
}
