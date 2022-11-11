package com.knits.ammolite.mapper.location;

import com.knits.ammolite.dto.location.LocationDto;
import com.knits.ammolite.mapper.common.AddressMapper;
import com.knits.ammolite.mapper.common.EntityMapper;
import com.knits.ammolite.model.location.Location;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",uses = {AddressMapper.class},unmappedTargetPolicy = ReportingPolicy.WARN)
public interface LocationMapper extends EntityMapper<Location,LocationDto> {
}

