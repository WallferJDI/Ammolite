package com.knits.ammolite.service.mapper;

import com.knits.ammolite.model.building.Reception;
import com.knits.ammolite.service.dto.building.ReceptionDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReceptionMapper extends EntityMapper<Reception,ReceptionDto> {

}
