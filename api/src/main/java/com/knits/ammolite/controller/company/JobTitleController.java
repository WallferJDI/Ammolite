package com.knits.ammolite.controller.company;

import com.knits.ammolite.service.company.JobTitleService;
import com.knits.ammolite.dto.company.JobTitleDto;
import com.knits.ammolite.dto.search.JobTitleSearchDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job-title")
@Slf4j
public class JobTitleController {

    @Autowired
    JobTitleService jobTitleService;

    @PostMapping(value = "/create", produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<JobTitleDto> createJobTitle(@RequestBody JobTitleDto jobTitleDto) {
        log.debug("REST request to create JobTitle ");
        return ResponseEntity.ok().body(jobTitleService.createJobTitle(jobTitleDto));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> deleteJobTitle(@PathVariable Long id) {
        log.debug("REST request to delete JobTitle : {}", id);
        jobTitleService.deleteJobTitle(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/partial-update", produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<JobTitleDto> partialUpdate(@RequestBody JobTitleDto jobTitleDto) {
        log.debug("REST request to update BusinessUnit ");
        return ResponseEntity.ok().body(jobTitleService.partialUpdate(jobTitleDto));
    }

    @GetMapping(value = "/search", produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<List<JobTitleDto>> getActive(@RequestBody JobTitleSearchDto jobTitleSearchDto) {
        log.debug("REST request to search BusinessUnit");
        return ResponseEntity.ok().body(jobTitleService.getActive(jobTitleSearchDto).toList());
    }

    @GetMapping(value = "/search-all", produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<List<JobTitleDto>> getAll(@RequestBody JobTitleSearchDto jobTitleSearchDto) {
        log.debug("REST request to search BusinessUnit");
        return ResponseEntity.ok().body(jobTitleService.getAll(jobTitleSearchDto).toList());
    }

}
