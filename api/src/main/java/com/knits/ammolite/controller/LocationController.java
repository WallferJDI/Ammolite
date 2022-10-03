package com.knits.ammolite.controller;

import com.knits.ammolite.service.LocationService;
import com.knits.ammolite.service.dto.LocationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/location")
public class LocationController {

    private LocationService locationService;

    @PostMapping("/create")
    public ResponseEntity<LocationDto> create(@RequestBody LocationDto locationDto){
        locationService.createLocation(locationDto);
        return new ResponseEntity<>(locationDto, HttpStatus.OK);
    }




}
