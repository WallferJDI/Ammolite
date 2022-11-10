package com.knits.ammolite.repository.location;

import com.knits.ammolite.model.location.Floor;
import com.knits.ammolite.model.enums.LocationUsageType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FloorRepository extends JpaRepository<Floor,Long> {

    List<Floor>findAllByRealEstate(LocationUsageType realEstate);


}
