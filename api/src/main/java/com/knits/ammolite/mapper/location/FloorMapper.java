package com.knits.ammolite.mapper.location;

import com.knits.ammolite.dto.location.FloorDto;
import com.knits.ammolite.mapper.common.EntityMapper;
import com.knits.ammolite.model.location.Floor;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",uses = {BuildingMapper.class},unmappedTargetPolicy = ReportingPolicy.WARN)
public interface FloorMapper extends EntityMapper<Floor, FloorDto> {


}



