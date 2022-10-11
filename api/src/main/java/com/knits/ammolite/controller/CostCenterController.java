package com.knits.ammolite.controller;

import com.knits.ammolite.service.CostCenterService;
import com.knits.ammolite.service.dto.CostCenterDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cost-center")
@Slf4j
public class CostCenterController {

    @Autowired
    private CostCenterService costCenterService;

    @PostMapping(value = "/create", produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<CostCenterDto> createBusinessUnit(@RequestBody CostCenterDto costCenterDto) {
        log.debug("REST request to create CostCenter ");
        return ResponseEntity.ok().body(costCenterService.createBusinessUnit(costCenterDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCostCenter(@PathVariable Long id) {
        log.debug("REST request to delete CostCenter : {}", id);
        costCenterService.deleteCostCenter(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/update", produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<CostCenterDto> partialUpdate(@RequestBody CostCenterDto costCenterDto) {
        log.debug("REST request to update CostCenter ");
        return ResponseEntity.ok().body(costCenterService.partialUpdate(costCenterDto));
    }
}
