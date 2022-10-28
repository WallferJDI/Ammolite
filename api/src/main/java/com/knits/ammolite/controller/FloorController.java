package com.knits.ammolite.controller;

import com.knits.ammolite.exceptions.FloorException;
import com.knits.ammolite.service.FloorService;
import com.knits.ammolite.service.dto.FloorDto;
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
            throw new FloorException("Floor data are missing");
        }
        return ResponseEntity.ok().body(floorService.create(floorDto));
    }

    @GetMapping(value = "/all", produces = {"application/json"})
    public ResponseEntity<List<FloorDto>> getAll() {
        log.debug("REST request to get all Floors");
        return ResponseEntity
                .ok()
                .body(floorService.findAll());
    }


}
