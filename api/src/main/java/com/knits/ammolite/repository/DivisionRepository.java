package com.knits.ammolite.repository;

import com.knits.ammolite.model.Division;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DivisionRepository extends PagingAndSortingRepository<Division, Long>,
        JpaSpecificationExecutor<Division> {

    @Query("SELECT e from CostCenter e where e.status = 'ACTIVE'")
    Page<Division> findAllDivisions(Specification<Division> costCenterSpecification, Pageable pageable);
}
