package com.knits.ammolite.service.mapper;

import com.knits.ammolite.model.Team;
import com.knits.ammolite.service.dto.TeamDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface TeamMapper {
    TeamDto toDto(Team team);

    @InheritInverseConfiguration
    Team toEntity(TeamDto teamDto);
}
