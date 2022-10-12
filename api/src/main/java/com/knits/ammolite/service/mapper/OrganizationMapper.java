package com.knits.ammolite.service.mapper;

import com.knits.ammolite.model.organization.Organization;
import com.knits.ammolite.service.dto.OrganizationDto;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface OrganizationMapper {


    @InheritInverseConfiguration
    Organization toEntity(OrganizationDto dto);

    OrganizationDto toDto(Organization entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(@MappingTarget Organization entity, OrganizationDto dto);

    void update( @MappingTarget Organization entity, OrganizationDto dto);

}