package com.knits.ammolite.repository;

import com.knits.ammolite.model.location.Location;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location,Long>,PagingAndSortingRepository<Location,Long>, JpaSpecificationExecutor<Location> {

    @Query("select l FROM Location l WHERE l.isDeleted = false")
    Page<Location> findAll(Specification<Location> s, Pageable p);

    Location findByTitle(String location);



}
