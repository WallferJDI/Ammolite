package com.knits.ammolite.mapper.company;

import com.knits.ammolite.dto.company.GroupDto;
import com.knits.ammolite.mapper.common.EntityMapper;
import com.knits.ammolite.mapper.security.UserMapper;
import com.knits.ammolite.model.company.Group;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface GroupMapper extends EntityMapper<Group, GroupDto> {
}
