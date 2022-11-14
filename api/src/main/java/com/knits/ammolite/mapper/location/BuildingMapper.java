package com.knits.ammolite.mapper.location;

import com.knits.ammolite.dto.location.BuildingDto;
import com.knits.ammolite.mapper.common.ContactPersonMapper;
import com.knits.ammolite.mapper.common.EntityMapper;
import com.knits.ammolite.model.location.Building;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        uses = {ContactPersonMapper.class, LocationMapper.class},
        unmappedTargetPolicy = ReportingPolicy.WARN)
public interface BuildingMapper extends EntityMapper<Building,BuildingDto> {


}
