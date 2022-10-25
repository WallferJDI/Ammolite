package com.knits.ammolite.controller;

import com.knits.ammolite.exceptions.UserException;
import com.knits.ammolite.model.building.Building;
import com.knits.ammolite.service.BuildingService;
import com.knits.ammolite.service.dto.UserDto;
import com.knits.ammolite.service.dto.building.BuildingDto;
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
    public ResponseEntity<BuildingDto> createLocation(@RequestBody BuildingDto buildingDto){
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
}
