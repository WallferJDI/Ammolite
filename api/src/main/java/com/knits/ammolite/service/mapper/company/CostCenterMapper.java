package com.knits.ammolite.service.mapper.company;

import com.knits.ammolite.model.company.CostCenter;
import com.knits.ammolite.service.dto.company.CostCenterDto;
import com.knits.ammolite.service.mapper.EntityMapper;
import com.knits.ammolite.service.mapper.UserMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.WARN,
        imports = {UserMapper.class})
public interface CostCenterMapper extends EntityMapper<CostCenter, CostCenterDto> {

    @Mapping(target = "createdBy", ignore = true)
    CostCenterDto toDto(CostCenter costCenter);
}
