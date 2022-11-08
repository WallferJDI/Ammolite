package com.knits.ammolite.repository.company;

import com.knits.ammolite.model.company.CostCenter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostCenterRepository extends PagingAndSortingRepository<CostCenter, Long>,
        JpaSpecificationExecutor<CostCenter> {

    @Query("SELECT e from CostCenter e where e.status = 'ACTIVE'")
    Page<CostCenter> findAllCostCenters(Specification<CostCenter> costCenterSpecification, Pageable pageable);


}
