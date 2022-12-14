package com.knits.ammolite.controller.location;

import com.knits.ammolite.dto.location.BuildingDto;
import com.knits.ammolite.dto.location.LocationDto;
import com.knits.ammolite.exceptions.UserException;
import com.knits.ammolite.service.location.BuildingService;
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
    public ResponseEntity<List<BuildingDto>> getAllBuildings(@RequestBody LocationDto locationDto) {
        log.debug("REST request to get all Buildings by Location");
        return ResponseEntity
                .ok()
                .body(buildingService.findAllByLocation(locationDto));
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
            throw new UserException("Building data are missing");
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
