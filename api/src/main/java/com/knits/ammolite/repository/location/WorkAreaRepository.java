package com.knits.ammolite.repository.location;

import com.knits.ammolite.model.location.WorkArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkAreaRepository extends JpaRepository<WorkArea,Long> {
    List<WorkArea> findAllByFloor_FloorNumber(String floorNumber);
}
