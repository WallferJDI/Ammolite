package com.knits.ammolite.controller.company;


import com.knits.ammolite.service.company.GroupService;
import com.knits.ammolite.dto.company.GroupDto;
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
public class GroupController {

    private final GroupService groupService;

    @PostMapping(value = "/groups",produces = {"application/json"}, consumes = { "application/json"})
    public ResponseEntity<GroupDto> createGroup(@RequestBody GroupDto groupDto){
        log.debug("REST request to create Group");
        return ResponseEntity.ok()
                .body(groupService.createGroup(groupDto));
    }
}
