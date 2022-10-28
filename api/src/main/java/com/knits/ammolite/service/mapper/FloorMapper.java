package com.knits.ammolite.service.mapper;

import com.knits.ammolite.model.Floor;
import com.knits.ammolite.model.building.Building;
import com.knits.ammolite.service.dto.FloorDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",imports = {Building.class})
public interface FloorMapper extends EntityMapper<Floor, FloorDto> {
}
