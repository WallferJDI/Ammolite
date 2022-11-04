package com.knits.ammolite.service.mapper.building;

import com.knits.ammolite.model.location.Reception;
import com.knits.ammolite.service.dto.building.ReceptionDto;
import com.knits.ammolite.service.mapper.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReceptionMapper extends EntityMapper<Reception,ReceptionDto> {

}
