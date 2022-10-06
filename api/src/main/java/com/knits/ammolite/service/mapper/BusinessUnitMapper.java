package com.knits.ammolite.service.mapper;

import com.knits.ammolite.model.BusinessUnit;
import com.knits.ammolite.service.dto.BusinessUnitDto;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface BusinessUnitMapper {


    BusinessUnitDto toDto(BusinessUnit businessUnit);

    @InheritInverseConfiguration
    BusinessUnit toEntity(BusinessUnitDto businessUnitDto);

    @Named("update")
    void update(@MappingTarget BusinessUnit businessUnit, BusinessUnitDto businessUnitDto);

    @Named("partialUpdate")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(@MappingTarget BusinessUnit businessUnit, BusinessUnitDto businessUnitDto);
}
