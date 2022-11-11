package com.knits.ammolite.controller.company;

import com.knits.ammolite.service.company.TeamService;
import com.knits.ammolite.dto.company.TeamDto;
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
public class TeamController {

    private final TeamService teamService;

    @PostMapping(value = "/teams", produces = {"application/json"}, consumes = { "application/json"})
    public ResponseEntity<TeamDto> createTeam(@RequestBody TeamDto teamDto){
        log.debug("REST request to create Team");
        return ResponseEntity.ok()
                .body(teamService.createTeam(teamDto));
    }
}
