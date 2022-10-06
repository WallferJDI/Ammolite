package com.knits.ammolite.controller;

import com.knits.ammolite.exceptions.UserException;
import com.knits.ammolite.service.BusinessUnitService;
import com.knits.ammolite.service.dto.BusinessUnitDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/business-unit")
@Slf4j
public class BusinessUnitController {

    @Autowired
    private BusinessUnitService businessUnitService;

    @PostMapping(value = "/create", produces = {"application/json"}, consumes = { "application/json"})
    public ResponseEntity<BusinessUnitDto> createBusinessUnit(@RequestBody BusinessUnitDto businessUnitDto){
        log.debug("REST request to create BusinessUnit ");
        if (businessUnitDto == null) {
            throw new UserException("BusinessUnit data are missing");
        }
        return ResponseEntity.ok().body(businessUnitService.createBusinessUnit(businessUnitDto));
    }
}
