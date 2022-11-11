package com.knits.ammolite.mapper.company;

import com.knits.ammolite.mapper.common.EntityMapper;
import com.knits.ammolite.mapper.security.UserMapper;
import com.knits.ammolite.model.company.CostCenter;
import com.knits.ammolite.dto.company.CostCenterDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.WARN,
        uses = {UserMapper.class})
public interface CostCenterMapper extends EntityMapper<CostCenter, CostCenterDto> {

    @Mapping(target = "createdBy", ignore = true)
    CostCenterDto toDto(CostCenter costCenter);
}
