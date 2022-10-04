package com.knits.ammolite.controller;

import com.knits.ammolite.exceptions.UserException;
import com.knits.ammolite.service.LocationService;
import com.knits.ammolite.service.dto.LocationDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/location")
public class LocationController {
    @Autowired
    private LocationService locationService;

    @PostMapping(value = "/create",produces = {"application/json"}, consumes = { "application/json"})
    public ResponseEntity<LocationDto> createLocation(@RequestBody LocationDto locationDto){
        log.debug("REST request to createLocation Location ");
        if (locationDto == null) {
            throw new UserException("Location data are missing");
        }
        return ResponseEntity.ok().body(locationService.createLocation(locationDto));
    }

    @PutMapping(value = "/edit", produces = {"application/json"}, consumes = { "application/json"})
    public ResponseEntity<LocationDto> editLocation(@RequestBody LocationDto locationDto){
        log.debug("REST request to editLocation Location ");
        if (locationDto == null) {
            throw new UserException("Location data are missing");
        }
        return ResponseEntity.ok().body(locationService.editLocation(locationDto));
    }}
