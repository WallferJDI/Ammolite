package com.knits.ammolite.controller;

import com.knits.ammolite.service.OrganizationService;
import com.knits.ammolite.service.dto.OrganizationDto;
import com.knits.ammolite.service.dto.search.OrganizationSearchDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;


    @PostMapping(value = "/organizations", produces = {"application/json"}, consumes = { "application/json"})
    public ResponseEntity<OrganizationDto> createOrganization(@RequestBody OrganizationDto organizationDto){
        log.debug("REST request to create Organization");
        return ResponseEntity.ok()
                .body(organizationService.save(organizationDto));
    }

    @PutMapping(value = "/organizations", produces = {"application/json"}, consumes = { "application/json"})
    public ResponseEntity<OrganizationDto> updateOrganization(@RequestBody OrganizationDto organizationDto){
        log.debug("REST request to update Organization");
        return ResponseEntity.ok()
                .body(organizationService.update(organizationDto));
    }

    @GetMapping(value = "/organizations")
    public ResponseEntity<List<OrganizationDto>> search(OrganizationSearchDto searchDto ){
        log.debug("request to search organization");
        return ResponseEntity.ok()
                .body(organizationService.search(searchDto).toList());
    }


}
