package com.knits.ammolite.repository;

import com.knits.ammolite.model.Division;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DivisionRepository  extends PagingAndSortingRepository<Division, Long>,
        JpaSpecificationExecutor<Division> {
}
