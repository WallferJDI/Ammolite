package com.knits.ammolite.mapper.company;

import com.knits.ammolite.mapper.common.EntityMapper;
import com.knits.ammolite.mapper.security.UserMapper;
import com.knits.ammolite.model.company.BusinessUnit;
import com.knits.ammolite.dto.company.BusinessUnitDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.WARN,
        uses = {UserMapper.class})
public interface BusinessUnitMapper extends EntityMapper<BusinessUnit, BusinessUnitDto> {

    @Mapping(target = "createdBy", ignore = true)
    BusinessUnitDto toDto(BusinessUnit businessUnit);
}
