package com.knits.ammolite.controller;

import com.knits.ammolite.service.DivisionService;
import com.knits.ammolite.service.dto.DivisionDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
