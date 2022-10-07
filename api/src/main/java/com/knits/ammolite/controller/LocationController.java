package com.knits.ammolite.controller;

import com.knits.ammolite.exceptions.UserException;
import com.knits.ammolite.search.LocationSearchDto;
import com.knits.ammolite.service.LocationService;
import com.knits.ammolite.service.dto.LocationDto;
import com.knits.ammolite.service.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/location")
public class LocationController {
    @Autowired
    private LocationService locationService;

    @PostMapping(value = "/create",produces = {"application/json"}, consumes = { "application/json"})
    public ResponseEntity<LocationDto> createLocation(@RequestBody LocationDto locationDto){
        log.debug("REST request to createLocation Location ");
        checkIfNullOrEmpty(locationDto);
        if (locationDto == null) {
            throw new UserException("Location data are missing");
        }
        return ResponseEntity.ok().body(locationService.create(locationDto));
    }

    @PutMapping(value = "/update", produces = {"application/json"}, consumes = { "application/json"})
    public ResponseEntity<LocationDto> updateLocation(@RequestBody LocationDto locationDto){
        log.debug("REST request to editLocation Location");
        if (locationDto == null) {
            throw new UserException("Location data are missing");
        }
        return ResponseEntity.ok().body(locationService.update(locationDto));
    }

    @PatchMapping(value = "/update/{id}",  produces = {"application/json"}, consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<LocationDto> partialUpdateLocation(
            @PathVariable(value = "id", required = false) final Long id,
            @RequestBody LocationDto locationDto){
        log.debug("REST request to partialUpdateLocation Location ");

        if (locationDto == null) {
            throw new UserException("Location data are missing");
        }
        return ResponseEntity
                .ok()
                .body(locationService.partialUpdate(locationDto));
    }

    @GetMapping(value = "/list",produces = {"application/json"}, consumes = { "application/json"})
    public ResponseEntity<List<LocationDto>> findAll(
            @RequestParam(value = "isDeleted", required = false, defaultValue = "false") boolean isDeleted) {
        log.debug("REST request to get all Locations that : {}",isDeleted);
        return ResponseEntity.ok().body(locationService.findAll(isDeleted));
    }

    @PutMapping(value = "/delete/{id}",produces = {"application/json"}, consumes = { "application/json"})
    public ResponseEntity<Void> deleteLocation(@PathVariable Long id) {
        log.debug("REST request to delete Location with Id : {}", id);
        locationService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/search",produces = {"application/json"}, consumes = { "application/json"})
    public ResponseEntity<List<LocationDto>> searchLocation(@RequestBody LocationSearchDto locationSearch){
        log.debug("REST request to search Location by: {}",locationSearch);
        return ResponseEntity.ok().body(locationService.search(locationSearch).toList());
    }

    public void checkIfNullOrEmpty(LocationDto locationDto){
        String title = locationDto.getTitle();
        String country = String.valueOf(locationDto.getCountry());
        String address = locationDto.getAddress();
        String zipCode = locationDto.getZipCode();
        if(title==null||title.isEmpty()){
            String titleMessage = "Title can`t be null or empty";
            log.warn(titleMessage);
            throw new UserException(titleMessage);
        } if (country==null||country.isEmpty()){
            String countryMessage = "Country can`t be null or empty";
            log.warn(countryMessage);
            throw new UserException(countryMessage);}
        if (address==null||address.isEmpty()){
            String addressMessage = "Address can`t be null or empty";
            log.warn(addressMessage);
            throw new UserException(addressMessage);}
        if (zipCode==null||zipCode.isEmpty()){
            String zipCodeMessage = "ZipCode can`t be null or empty";
            log.warn(zipCodeMessage);
            throw new UserException(zipCodeMessage);}
    }



}
