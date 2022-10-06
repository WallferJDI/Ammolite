package com.knits.ammolite.service.mapper;

import com.knits.ammolite.model.BusinessUnit;
import com.knits.ammolite.service.dto.BusinessUnitDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface BusinessUnitMapper {


    BusinessUnitDto toDto(BusinessUnit businessUnit);

    @InheritInverseConfiguration
    BusinessUnit toEntity(BusinessUnitDto businessUnitDto);

    void update(BusinessUnitDto businessUnitDto, @MappingTarget BusinessUnit businessUnit);
}
