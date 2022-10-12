package com.knits.ammolite.controller;

import com.knits.ammolite.service.DivisionService;
import com.knits.ammolite.service.dto.DivisionDto;
import com.knits.ammolite.service.dto.search.DivisionSearchDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/division")
@Slf4j
public class DivisionController {

    @Autowired
    private DivisionService divisionService;

    @PostMapping(value = "/create", produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<DivisionDto> createBusinessUnit(@RequestBody DivisionDto divisionDto) {
        log.debug("REST request to create Division ");
        return ResponseEntity.ok().body(divisionService.createDivision(divisionDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteDivision(@PathVariable Long id) {
        log.debug("REST request to delete Division : {}", id);
        divisionService.deleteDivision(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/update", produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<DivisionDto> partialUpdate(@RequestBody DivisionDto divisionDto) {
        log.debug("REST request to update Division ");
        return ResponseEntity.ok().body(divisionService.partialUpdate(divisionDto));
    }

    @GetMapping(value = "/search-all", produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<List<DivisionDto>> getAll(@RequestBody DivisionSearchDto divisionSearchDto) {
        log.debug("REST request to search Division");
        return ResponseEntity.ok().body(divisionService.getAll(divisionSearchDto).toList());
    }

    @GetMapping(value = "/search", produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<List<DivisionDto>> getActive(@RequestBody DivisionSearchDto divisionSearchDto) {
        log.debug("REST request to search Division");
        return ResponseEntity.ok().body(divisionService.getActive(divisionSearchDto).toList());
    }
}
