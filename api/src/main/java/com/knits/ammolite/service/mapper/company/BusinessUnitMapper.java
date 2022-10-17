package com.knits.ammolite.service.mapper.company;

import com.knits.ammolite.model.company.BusinessUnit;
import com.knits.ammolite.service.dto.company.BusinessUnitDto;
import com.knits.ammolite.service.mapper.EntityMapper;
import com.knits.ammolite.service.mapper.UserMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.WARN,
        imports = {UserMapper.class})
public interface BusinessUnitMapper extends EntityMapper<BusinessUnit, BusinessUnitDto> {

    @Mapping(target = "createdBy", ignore = true)
    BusinessUnitDto toDto(BusinessUnit businessUnit);
}
