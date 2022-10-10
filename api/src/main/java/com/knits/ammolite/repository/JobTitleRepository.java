package com.knits.ammolite.repository;

import com.knits.ammolite.model.BusinessUnit;
import com.knits.ammolite.model.JobTitle;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobTitleRepository extends PagingAndSortingRepository<JobTitle, Long>,
        JpaSpecificationExecutor<JobTitle> {
}
