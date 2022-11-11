package com.knits.ammolite.repository.company;

import com.knits.ammolite.model.company.Department;
import com.knits.ammolite.model.company.Division;
import com.knits.ammolite.model.company.Gender;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DivisionRepository extends PagingAndSortingRepository<Division, Long>,
        JpaSpecificationExecutor<Division> {

    @Query("SELECT e from CostCenter e where e.status = 'ACTIVE'")
    Page<Division> findAllDivisions(Specification<Division> costCenterSpecification, Pageable pageable);

    interface DepartmentRepository extends JpaRepository<Department, Long> {
    }
}
