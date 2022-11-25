package com.knits.ammolite.controller.asset;

import com.knits.ammolite.dto.template.WarrantyTemplateDto;
import com.knits.ammolite.service.template.WarrantyTemplateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/warranty")
@Slf4j
@RequiredArgsConstructor
public class WarrantyController {
    private final WarrantyTemplateService service;

    @PostMapping(value = "/asset-parts",produces = {"application/json"}, consumes = { "application/json"})
    public ResponseEntity<WarrantyTemplateDto> createWarrantyTemplate(@RequestBody WarrantyTemplateDto template){
        log.debug("REST request to create Warranty Template", template);
        return ResponseEntity.ok()
                .body(service.save(template));
    }
}
