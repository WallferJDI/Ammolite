package com.knits.ammolite.mapper.common;

import com.knits.ammolite.dto.common.OrganizationDto;
import com.knits.ammolite.model.common.Organization;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrganizationMapper extends EntityMapper<Organization, OrganizationDto>{
}
