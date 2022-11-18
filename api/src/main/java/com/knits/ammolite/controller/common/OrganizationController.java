package com.knits.ammolite.controller.common;


import com.knits.ammolite.dto.common.OrganizationDto;
import com.knits.ammolite.dto.search.OrganizationSearchDto;
import com.knits.ammolite.service.common.OrganizationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/organizations")
@Slf4j
@RequiredArgsConstructor
public class OrganizationController {

    private final OrganizationService organizationService;


    @PostMapping(produces = {"application/json"}, consumes = { "application/json"})
    public ResponseEntity<OrganizationDto> createOrganization(@RequestBody OrganizationDto organizationDto){
        log.debug("REST request to create Organization");
        return ResponseEntity.ok()
                .body(organizationService.save(organizationDto));
    }

    @PutMapping(produces = {"application/json"}, consumes = { "application/json"})
    public ResponseEntity<OrganizationDto> partialUpdateOrganization(@RequestBody OrganizationDto organizationDto){
        log.debug("REST request to update Organization");
        return ResponseEntity.ok()
                .body(organizationService.partialUpdate(organizationDto));
    }

    @GetMapping(value = "/search")
    public ResponseEntity<List<OrganizationDto>> searchOrganization(OrganizationSearchDto searchDto ){
        log.debug("request to search organization");
        return ResponseEntity.ok()
                .body(organizationService.search(searchDto).toList());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrganization(@PathVariable Long id){
        log.debug("REST request to delete Organization : {}", id);
        organizationService.delete(id);
        return ResponseEntity.noContent().build();
    }


}

