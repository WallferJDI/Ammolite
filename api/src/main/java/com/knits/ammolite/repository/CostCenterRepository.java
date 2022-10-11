package com.knits.ammolite.repository;

import com.knits.ammolite.model.CostCenter;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostCenterRepository extends PagingAndSortingRepository<CostCenter, Long>,
        JpaSpecificationExecutor<CostCenter> {
}
