package com.knits.ammolite.controller.asset;

import com.knits.ammolite.dto.asset.AssetPartDto;
import com.knits.ammolite.service.asset.AssetPartService;
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
public class AssetPartController {

    private final AssetPartService assetPartService;

    @PostMapping(value = "/asset-parts",produces = {"application/json"}, consumes = { "application/json"})
    public ResponseEntity<AssetPartDto> createAssetPart(@RequestBody AssetPartDto assetPartDto){
        log.debug("REST request to create AssetInstance");
        return ResponseEntity.ok()
                .body(assetPartService.save(assetPartDto));
    }
}
