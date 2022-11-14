package com.knits.ammolite.controller.location;

import com.knits.ammolite.dto.location.FloorDto;
import com.knits.ammolite.exceptions.UserException;
import com.knits.ammolite.service.location.FloorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("api/building/floor")
public class FloorController {

    @Autowired
    FloorService floorService;

    @PostMapping(value = "/create",produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<FloorDto> createFloor(@RequestBody FloorDto floorDto){
        log.debug("REST request to create Floor");
        if (floorDto == null) {
            throw new UserException("Floor data are missing");
        }
        return ResponseEntity.ok().body(floorService.create(floorDto));
    }

    @GetMapping(value = "/all", produces = {"application/json"})
    public ResponseEntity<List<FloorDto>> getAll(@RequestBody FloorDto floorDto) {
        log.debug("REST request to get all Floors");
        return ResponseEntity
                .ok()
                .body(floorService.findAllByRealEstate(floorDto));
    }

    @PutMapping(value = "/update", produces = {"application/json"}, consumes = { "application/json"})
    public ResponseEntity<FloorDto> updateFloor(@RequestBody FloorDto floorDto){
        log.debug("REST request to edit Floor");
        if (floorDto == null) {
            throw new UserException("Floor data are missing");
        }
        return ResponseEntity.ok().body(floorService.update(floorDto));
    }

    @PatchMapping(value = "/update/{id}",  produces = {"application/json"}, consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<FloorDto> partialUpdateBuilding(
            @PathVariable(value = "id", required = false) final Long id,
            @RequestBody FloorDto floorDto){
        log.debug("REST request to partial update Floor ");

        if (floorDto == null) {
            throw new UserException("Floor data are missing");
        }
        return ResponseEntity
                .ok()
                .body(floorService.partialUpdate(floorDto));
    }

    @DeleteMapping(value = "/delete/{id}",produces = {"application/json"}, consumes = { "application/json"})
    public ResponseEntity<Void> deleteFloor(@PathVariable Long id) {
        log.debug("REST request to delete Floor with Id : {}", id);
        floorService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
