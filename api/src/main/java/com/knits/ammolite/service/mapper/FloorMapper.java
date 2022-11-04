package com.knits.ammolite.service.mapper;

import com.knits.ammolite.model.location.Floor;
import com.knits.ammolite.service.dto.FloorDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FloorMapper extends EntityMapper<Floor, FloorDto> {

}



