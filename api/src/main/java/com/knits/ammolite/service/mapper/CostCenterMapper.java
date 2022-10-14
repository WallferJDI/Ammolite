package com.knits.ammolite.service.mapper;

import com.knits.ammolite.model.BusinessUnit;
import com.knits.ammolite.model.CostCenter;
import com.knits.ammolite.service.dto.BusinessUnitDto;
import com.knits.ammolite.service.dto.CostCenterDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.WARN,
        imports = {UserMapper.class})
public interface CostCenterMapper extends EntityMapper<CostCenter, CostCenterDto>{

    @Mapping(target = "createdBy", ignore = true)
    CostCenterDto toDto(CostCenter costCenter);
}
