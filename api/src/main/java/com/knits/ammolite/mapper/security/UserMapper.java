package com.knits.ammolite.mapper.security;

import com.knits.ammolite.model.security.User;
import com.knits.ammolite.dto.security.UserDto;
import com.knits.ammolite.mapper.common.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.WARN)
public interface UserMapper extends EntityMapper<User, UserDto> {



}