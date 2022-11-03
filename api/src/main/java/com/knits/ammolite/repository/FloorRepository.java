package com.knits.ammolite.repository;

import com.knits.ammolite.model.Floor;
import com.knits.ammolite.model.location.RealEstateType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FloorRepository extends JpaRepository<Floor,Long> {

    List<Floor>findAllByRealEstate(RealEstateType realEstate);


}
