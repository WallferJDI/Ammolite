package com.knits.ammolite.controller.asset;

import com.knits.ammolite.dto.asset.AssetCategoryDto;
import com.knits.ammolite.service.asset.AssetCategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/asset-category")
@Slf4j
@RequiredArgsConstructor
public class AssetCategoryController {

    private final AssetCategoryService assetCategoryService;

    @PostMapping(produces = {"application/json"}, consumes = { "application/json"})
    public ResponseEntity<AssetCategoryDto> createAsset(@RequestBody AssetCategoryDto dto){
        log.debug("REST request to create Asset Category");
        return ResponseEntity.ok()
                .body(assetCategoryService.save(dto));

    }

}
