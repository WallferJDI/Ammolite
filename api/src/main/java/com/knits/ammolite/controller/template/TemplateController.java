package com.knits.ammolite.controller.template;


import com.knits.ammolite.dto.asset.AssetDto;
import com.knits.ammolite.dto.asset.AssetPartDto;
import com.knits.ammolite.dto.template.AssetTemplateDto;
import com.knits.ammolite.service.template.AssetTemplateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/template")
@Slf4j
@RequiredArgsConstructor
public class TemplateController {

    private final AssetTemplateService assetTemplateService;


    @PostMapping(value = "/assetparts",produces = {"application/json"}, consumes = { "application/json"})
    public ResponseEntity<AssetTemplateDto> createTemplate(@RequestBody AssetTemplateDto assetDto){
        log.debug("REST request to create AssetInstance");
        return ResponseEntity.ok()
                .body(assetTemplateService.createAssetTemplate(assetDto));
    }
}
