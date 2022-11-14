package com.knits.ammolite.repository.company;

import com.knits.ammolite.model.common.Organization;
import com.knits.ammolite.model.company.BusinessUnit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long>,PagingAndSortingRepository<Organization, Long>,
        JpaSpecificationExecutor<Organization> {
}
