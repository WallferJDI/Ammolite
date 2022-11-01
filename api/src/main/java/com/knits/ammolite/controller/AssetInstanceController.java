package com.knits.ammolite.controller;

import com.knits.ammolite.service.AssetInstanceService;
import com.knits.ammolite.service.dto.asset.AssetInstanceDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j
@RequiredArgsConstructor
public class AssetInstanceController {

    private final AssetInstanceService assetInstanceService;


    @PostMapping(value = "/asset-instances",produces = {"application/json"}, consumes = { "application/json"})
    public ResponseEntity<AssetInstanceDto> createAssetInstance(@RequestBody AssetInstanceDto assetInstanceDto){
        log.debug("REST request to create AssetInstance");
        return ResponseEntity.ok()
                .body(assetInstanceService.save(assetInstanceDto));
    }
}
