package com.knits.ammolite.service;

import com.knits.ammolite.model.Team;
import com.knits.ammolite.repository.TeamRepository;
import com.knits.ammolite.service.dto.TeamDto;
import com.knits.ammolite.service.mapper.TeamMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class TeamService {

    private final TeamMapper teamMapper;
    private final TeamRepository teamRepository;

    public TeamDto createTeam(TeamDto teamDto){
        log.debug("Request to save Team : {}", teamDto);
        Team team;
        if(teamRepository.existsById(teamDto.getId())){
            team = teamRepository.findById(teamDto.getId()).get();
        }else{
            team = teamRepository.save(teamMapper.toEntity(teamDto));
        }
        return teamMapper.toDto(team);

    }
}
