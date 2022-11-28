package com.knits.ammolite.controller.asset;


import com.knits.ammolite.dto.template.DepreciationTemplateDto;
import com.knits.ammolite.dto.template.WarrantyTemplateDto;
import com.knits.ammolite.model.template.DepreciationTemplate;
import com.knits.ammolite.service.template.DepreciationTemplateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/depreciation")
@Slf4j
@RequiredArgsConstructor
public class DepreciationController {

    private final DepreciationTemplateService templateService;

    @PostMapping(value = "/template",produces = {"application/json"}, consumes = { "application/json"})
    public ResponseEntity<DepreciationTemplateDto> createWarrantyTemplate(@RequestBody DepreciationTemplateDto template){
        log.debug("REST request to create Warranty Template", template);
        return ResponseEntity.ok()
                .body(templateService.save(template));
    }

}
