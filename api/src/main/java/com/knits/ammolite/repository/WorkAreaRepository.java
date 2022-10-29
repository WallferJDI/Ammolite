package com.knits.ammolite.repository;

import com.knits.ammolite.model.Floor;
import com.knits.ammolite.model.WorkArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkAreaRepository extends JpaRepository<WorkArea,Long> {
}
