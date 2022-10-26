package com.knits.ammolite.controller;

import com.knits.ammolite.exceptions.BuildingException;
import com.knits.ammolite.exceptions.UserException;
import com.knits.ammolite.model.building.Building;
import com.knits.ammolite.service.BuildingService;
import com.knits.ammolite.service.dto.UserDto;
import com.knits.ammolite.service.dto.building.BuildingDto;
import com.knits.ammolite.service.dto.location.LocationDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("api/building")
public class BuildingController {

    @Autowired
    private BuildingService buildingService;


    @PostMapping(value = "/create",produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<BuildingDto> createBuilding(@RequestBody BuildingDto buildingDto){
        log.debug("REST request to create Building");
        if (buildingDto == null) {
            throw new UserException("Building data are missing");
        }
        return ResponseEntity.ok().body(buildingService.create(buildingDto));
    }

    @GetMapping(value = "/all", produces = {"application/json"})
    public ResponseEntity<List<BuildingDto>> getAllBuildings() {
        log.debug("REST request to get all Buildings");
        return ResponseEntity
                .ok()
                .body(buildingService.findAll());
    }

    @PutMapping(value = "/update", produces = {"application/json"}, consumes = { "application/json"})
    public ResponseEntity<BuildingDto> updateBuilding(@RequestBody BuildingDto buildingDto){
        log.debug("REST request to edit Building");
        if (buildingDto == null) {
            throw new UserException("Location data are missing");
        }
        return ResponseEntity.ok().body(buildingService.update(buildingDto));
    }

    @PatchMapping(value = "/update/{id}",  produces = {"application/json"}, consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<BuildingDto> partialUpdateBuilding(
            @PathVariable(value = "id", required = false) final Long id,
            @RequestBody BuildingDto buildingDto){
        log.debug("REST request to partial update Building ");

        if (buildingDto == null) {
            throw new BuildingException("Building data are missing");
        }
        return ResponseEntity
                .ok()
                .body(buildingService.partialUpdate(buildingDto));
    }

    @DeleteMapping(value = "/delete/{id}",produces = {"application/json"}, consumes = { "application/json"})
    public ResponseEntity<Void> deleteBuilding(@PathVariable Long id) {
        log.debug("REST request to delete Building with Id : {}", id);
        buildingService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
