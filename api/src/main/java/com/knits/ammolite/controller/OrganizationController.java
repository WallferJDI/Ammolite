package com.knits.ammolite.controller;

import com.knits.ammolite.exceptions.OrganizationException;
import com.knits.ammolite.exceptions.UserException;
import com.knits.ammolite.service.OrganizationService;
import com.knits.ammolite.service.dto.OrganizationDto;
import com.knits.ammolite.service.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Slf4j
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;


    @PostMapping(value = "/organizations", produces = {"application/json"}, consumes = { "application/json"})
    public ResponseEntity<OrganizationDto> createOrganization(@RequestBody OrganizationDto organizationDto){
        log.debug("REST request to create Organization");
        if(organizationDto==null){
            throw new OrganizationException("Organization data is missing");
        }
        return ResponseEntity.ok()
                .body(organizationService.save(organizationDto));
    }

    @PutMapping(value = "/organizations", produces = {"application/json"}, consumes = { "application/json"})
    public ResponseEntity<OrganizationDto> updateOrganization(@RequestBody OrganizationDto organizationDto){
        log.debug("REST request to update Organization");
        if (organizationDto == null) {
            throw new OrganizationException("Organization data is missing");
        }

        return ResponseEntity.ok()
                .body(organizationService.update(organizationDto));
    }


}
