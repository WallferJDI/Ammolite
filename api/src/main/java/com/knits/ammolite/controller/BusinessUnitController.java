package com.knits.ammolite.controller;

import com.knits.ammolite.service.BusinessUnitService;
import com.knits.ammolite.service.dto.BusinessUnitDto;
import com.knits.ammolite.service.dto.search.BusinessUnitSearchDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/business-unit")
@Slf4j
public class BusinessUnitController {

    @Autowired
    private BusinessUnitService businessUnitService;

    @PostMapping(value = "/create", produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<BusinessUnitDto> createBusinessUnit(@RequestBody BusinessUnitDto businessUnitDto) {
        log.debug("REST request to create BusinessUnit ");
        return ResponseEntity.ok().body(businessUnitService.createBusinessUnit(businessUnitDto));
    }

    @PutMapping(value = "/update", produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<BusinessUnitDto> updateBusinessUnit(@RequestBody BusinessUnitDto businessUnitDto) {
        log.debug("REST request to updateBusinessUnit BusinessUnit ");
        return ResponseEntity.ok().body(businessUnitService.updateBusinessUnit(businessUnitDto));
    }

    @PutMapping(value = "/partial-update", produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<BusinessUnitDto> partialUpdate(@RequestBody BusinessUnitDto businessUnitDto) {
        log.debug("REST request to updateBusinessUnit BusinessUnit ");
        return ResponseEntity.ok().body(businessUnitService.partialUpdate(businessUnitDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBusinessUnit(@PathVariable Long id) {
        log.debug("REST request to delete BusinessUnit : {}", id);
        businessUnitService.deleteBusinessUnit(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/search", produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<List<BusinessUnitDto>> getActive(@RequestBody BusinessUnitSearchDto businessUnitSearchDto) {
        log.debug("REST request to search BusinessUnit");
        return ResponseEntity.ok().body(businessUnitService.getActive(businessUnitSearchDto).toList());
    }

    @GetMapping(value = "/search-all", produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<List<BusinessUnitDto>> getAll(@RequestBody BusinessUnitSearchDto businessUnitSearchDto) {
        log.debug("REST request to search BusinessUnit");
        return ResponseEntity.ok().body(businessUnitService.getAll(businessUnitSearchDto).toList());
    }
}
