package com.knits.ammolite.controller;

import com.knits.ammolite.service.OrganizationService;
import com.knits.ammolite.service.dto.OrganizationDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.knits.ammolite.payload.CreateOrganizationRequest;

@RestController
@RequestMapping("/api/organization")
@Slf4j
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;


    @PostMapping(value = "/create", produces = {"application/json"}, consumes = { "application/json"})
    public ResponseEntity<OrganizationDto> createOrganization(@RequestBody CreateOrganizationRequest createOrganizationRequest){
        log.debug("REST request to create Organization");
        if(createOrganizationRequest==null){
            throw new NullPointerException("Organization data is missing");
        }
        return ResponseEntity.ok()
                .body(organizationService.createOrganization(createOrganizationRequest));
    }


}
