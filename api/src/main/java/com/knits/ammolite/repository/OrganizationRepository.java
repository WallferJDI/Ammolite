package com.knits.ammolite.repository;

import com.knits.ammolite.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization,Long> {

   Optional<Organization> findByOrganizationName(String organizationName);
    Optional<Organization> findByVAT(String VAT);
}
