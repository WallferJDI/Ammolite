package com.knits.ammolite.service.mapper;

import com.knits.ammolite.model.BusinessUnit;
import com.knits.ammolite.service.dto.BusinessUnitDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface BusinessUnitMapper {

    BusinessUnitDto toDto(BusinessUnit businessUnit);

    @InheritInverseConfiguration
    BusinessUnit toEntity(BusinessUnitDto businessUnitDto);


    List<BusinessUnitDto> toDtos(List<BusinessUnit> businessUnits);

    @InheritInverseConfiguration
    List<BusinessUnit> toEntities(List<BusinessUnitDto> businessUnitDtos);

    @Named("update")
    void update(@MappingTarget BusinessUnit businessUnit, BusinessUnitDto businessUnitDto);

    @Named("partialUpdate")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(@MappingTarget BusinessUnit businessUnit, BusinessUnitDto businessUnitDto);
}
