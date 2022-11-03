package com.knits.ammolite.repository;

import com.knits.ammolite.model.Floor;
import com.knits.ammolite.model.WorkArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkAreaRepository extends JpaRepository<WorkArea,Long> {
    List<WorkArea> findAllByFloor_FloorNumber(String floorNumber);
}
