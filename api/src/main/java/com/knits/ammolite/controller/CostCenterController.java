package com.knits.ammolite.controller;

import com.knits.ammolite.service.CostCenterService;
import com.knits.ammolite.service.dto.CostCenterDto;
import com.knits.ammolite.service.dto.search.CostCenterSearchDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cost-center")
@Slf4j
public class CostCenterController {

    @Autowired
    private CostCenterService costCenterService;

    @PostMapping(value = "/create", produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<CostCenterDto> createBusinessUnit(@RequestBody CostCenterDto costCenterDto) {
        log.debug("REST request to create CostCenter ");
        return ResponseEntity.ok().body(costCenterService.createCostCenter(costCenterDto));
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

    @GetMapping(value = "/search-all", produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<List<CostCenterDto>> getAll(@RequestBody CostCenterSearchDto costCenterSearchDto) {
        log.debug("REST request to search CostCenter");
        return ResponseEntity.ok().body(costCenterService.getAll(costCenterSearchDto).toList());
    }

    @GetMapping(value = "/search", produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<List<CostCenterDto>> getActive(@RequestBody CostCenterSearchDto costCenterSearchDto) {
        log.debug("REST request to search CostCenter");
        return ResponseEntity.ok().body(costCenterService.getActive(costCenterSearchDto).toList());
    }
}
