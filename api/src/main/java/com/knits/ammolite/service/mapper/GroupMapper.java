package com.knits.ammolite.service.mapper;

import com.knits.ammolite.model.Group;

import com.knits.ammolite.service.dto.GroupDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface GroupMapper {

     GroupDto toDto(Group group);

     @InheritInverseConfiguration
     Group toEntity(GroupDto groupDto);
}
