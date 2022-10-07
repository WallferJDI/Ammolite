package com.knits.ammolite.repository;

import com.knits.ammolite.model.BusinessUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessUnitRepository extends PagingAndSortingRepository<BusinessUnit, Long>,
                                                JpaSpecificationExecutor<BusinessUnit> {
}
