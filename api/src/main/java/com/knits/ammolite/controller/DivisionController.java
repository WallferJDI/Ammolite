package com.knits.ammolite.controller;

import com.knits.ammolite.service.DivisionService;
import com.knits.ammolite.service.dto.DivisionDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/division")
@Slf4j
public class DivisionController {

    @Autowired
    private DivisionService divisionService;

    @PostMapping(value = "/create", produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<DivisionDto> createBusinessUnit(@RequestBody DivisionDto divisionDto) {
        log.debug("REST request to create BusinessUnit ");
        return ResponseEntity.ok().body(divisionService.createDivision(divisionDto));
    }
}
