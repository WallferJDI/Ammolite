package com.knits.ammolite.controller.location;

import com.knits.ammolite.exceptions.UserException;
import com.knits.ammolite.dto.search.LocationSearchDto;
import com.knits.ammolite.service.location.LocationService;
import com.knits.ammolite.dto.location.LocationDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("api/location")
public class LocationController {
    @Autowired
    private LocationService locationService;

    @PostMapping(value = "/create",produces = {"application/json"}, consumes = { "application/json"})
    public ResponseEntity<LocationDto> createLocation(@RequestBody LocationDto locationDto){
        log.debug("REST request to createLocation Location ");
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


}
