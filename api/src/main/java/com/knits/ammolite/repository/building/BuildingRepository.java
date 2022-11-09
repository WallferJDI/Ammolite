package com.knits.ammolite.repository.building;

import com.knits.ammolite.model.location.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuildingRepository extends JpaRepository<Building,Long> {

    List<Building> findAllByLocation_Title(String location);
}
