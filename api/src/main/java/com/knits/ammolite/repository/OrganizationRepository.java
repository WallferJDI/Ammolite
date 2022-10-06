package com.knits.ammolite.repository;

import com.knits.ammolite.model.organization.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;


public interface OrganizationRepository extends JpaSpecificationExecutor<Organization>, PagingAndSortingRepository<Organization,Long> {

   Optional<Organization> findByName(String organizationName);
    Optional<Organization> findByVAT(String VAT);
}
