package com.knits.ammolite.mapper.security;

import com.knits.ammolite.dto.RoleDto;
import com.knits.ammolite.mapper.common.EntityMapper;
import com.knits.ammolite.model.security.Role;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.WARN)
public interface RolerMapper extends EntityMapper<Role, RoleDto> {



}