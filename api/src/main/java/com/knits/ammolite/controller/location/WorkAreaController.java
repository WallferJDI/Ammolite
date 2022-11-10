package com.knits.ammolite.controller.location;

import com.knits.ammolite.dto.location.FloorDto;
import com.knits.ammolite.dto.location.WorkAreaDto;
import com.knits.ammolite.exceptions.UserException;
import com.knits.ammolite.service.location.WorkAreaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("api/building/floor/work_area")
public class WorkAreaController {

    @Autowired
    private WorkAreaService workAreaService;

    @PostMapping(value = "/create",produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<WorkAreaDto> createFloor(@RequestBody WorkAreaDto workAreaDto){
        log.debug("REST request to create Work Area");
        if (workAreaDto == null) {
            throw new UserException("Work Area data are missing");
        }
        return ResponseEntity.ok().body(workAreaService.create(workAreaDto));
    }

    @GetMapping(value = "/all", produces = {"application/json"})
    public ResponseEntity<List<WorkAreaDto>> getAll(@RequestBody FloorDto floorDto) {
        log.debug("REST request to get all Work Areas by Floor number");
        return ResponseEntity
                .ok()
                .body(workAreaService.findAllByFloorNumber(floorDto));
    }

    @DeleteMapping(value = "/delete/{id}",produces = {"application/json"}, consumes = { "application/json"})
    public ResponseEntity<Void> deleteWorkArea(@PathVariable Long id) {
        log.debug("REST request to delete Work Area with Id : {}", id);
        workAreaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/update", produces = {"application/json"}, consumes = { "application/json"})
    public ResponseEntity<WorkAreaDto> updateWorkArea(@RequestBody WorkAreaDto workAreaDto){
        log.debug("REST request to edit Work Area");
        if (workAreaDto == null) {
            throw new UserException("Work Area data are missing");
        }
        return ResponseEntity.ok().body(workAreaService.update(workAreaDto));
    }

    @PatchMapping(value = "/update/{id}",  produces = {"application/json"}, consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<WorkAreaDto> partialUpdateWorkArea(
            @PathVariable(value = "id", required = false) final Long id,
            @RequestBody WorkAreaDto workAreaDto){
        log.debug("REST request to partial update Work Area ");

        if (workAreaDto == null) {
            throw new UserException("Work Area data are missing");
        }
        return ResponseEntity
                .ok()
                .body(workAreaService.partialUpdate(workAreaDto));
    }
}
