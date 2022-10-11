package com.knits.ammolite.service.mapper;

import com.knits.ammolite.model.CostCenter;
import com.knits.ammolite.service.dto.CostCenterDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.WARN,
        imports = {UserMapper.class})
public interface CostCenterMapper extends EntityMapper<CostCenter, CostCenterDto>{
}
