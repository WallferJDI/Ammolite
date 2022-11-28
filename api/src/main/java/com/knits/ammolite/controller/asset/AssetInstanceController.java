package com.knits.ammolite.controller.asset;

import com.knits.ammolite.dto.asset.WarrantyDto;
import com.knits.ammolite.service.asset.AssetInstanceService;
import com.knits.ammolite.dto.asset.AssetInstanceDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/asset-instances")
@Slf4j
@RequiredArgsConstructor
public class AssetInstanceController {

    private final AssetInstanceService assetInstanceService;


    @PostMapping(produces = {"application/json"}, consumes = { "application/json"})
    public ResponseEntity<AssetInstanceDto> createAssetInstance(@RequestBody AssetInstanceDto assetInstanceDto){
        log.debug("REST request to create AssetInstance");
        return ResponseEntity.ok()
                .body(assetInstanceService.save(assetInstanceDto));
    }


    @PostMapping(value = "/asset-add-warranty",produces = {"application/json"}, consumes = { "application/json"})
    public ResponseEntity<AssetInstanceDto> addWarranty(@RequestBody AssetInstanceDto assetInstanceDto, WarrantyDto warrantyDto){
        log.debug("REST request to create AssetInstance");
        return ResponseEntity.ok()
                .body(assetInstanceService.addWarrantyToExistingInstance(assetInstanceDto,warrantyDto));
    }
}
