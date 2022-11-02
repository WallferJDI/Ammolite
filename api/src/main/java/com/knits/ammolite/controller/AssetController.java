package com.knits.ammolite.controller;

import com.knits.ammolite.service.AssetService;
import com.knits.ammolite.service.dto.asset.AssetDto;
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
public class AssetController {

    private final AssetService assetService;

    @PostMapping(value = "/assets",produces = {"application/json"}, consumes = { "application/json"})
    public ResponseEntity<AssetDto> createAsset(@RequestBody AssetDto assetDto){
        log.debug("REST request to create Asset");
        return ResponseEntity.ok()
                .body(assetService.save(assetDto));

    }
}
