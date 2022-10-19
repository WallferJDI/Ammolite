package com.knits.ammolite.service.mapper;

import com.knits.ammolite.model.BusinessUnit;
import com.knits.ammolite.service.dto.BusinessUnitDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.WARN,
        uses = {UserMapper.class})
public interface BusinessUnitMapper extends EntityMapper<BusinessUnit, BusinessUnitDto>{
}
