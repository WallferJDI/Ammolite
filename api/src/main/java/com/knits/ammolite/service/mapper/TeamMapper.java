package com.knits.ammolite.service.mapper;

import com.knits.ammolite.model.organization.Team;
import com.knits.ammolite.service.dto.TeamDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface TeamMapper extends AbstractMapper<TeamDto,Team> {
}
