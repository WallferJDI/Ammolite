package com.knits.ammolite.controller.asset;

import com.fasterxml.jackson.annotation.JsonView;
import com.knits.ammolite.config.Views;
import com.knits.ammolite.service.asset.AssetService;
import com.knits.ammolite.dto.asset.AssetDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assets")
@Slf4j
@RequiredArgsConstructor
public class AssetController {

    private final AssetService assetService;

    @PostMapping(produces = {"application/json"}, consumes = { "application/json"})
    public ResponseEntity<AssetDto> createAsset(@RequestBody AssetDto assetDto){
        log.debug("REST request to create Asset");
        return ResponseEntity.ok()
                .body(assetService.save(assetDto));

    }
    @GetMapping(value = "/all")
    @JsonView(Views.Public.class)
    public ResponseEntity<List<AssetDto>> getAllAssets(){
        return ResponseEntity.ok()
                .body(assetService.getAllAssets());
    }
    @JsonView(Views.Public.class)
    @PutMapping(produces = {"application/json"}, consumes = { "application/json"})
    public ResponseEntity<AssetDto> partialUpdate(AssetDto assetDto){
        log.debug("Request to add photo to Asset");
        return ResponseEntity.ok()
                .body(assetService.partialUpdate(assetDto));
    }
}
