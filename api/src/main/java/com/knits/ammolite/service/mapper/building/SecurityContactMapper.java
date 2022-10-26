package com.knits.ammolite.service.mapper.building;

import com.knits.ammolite.model.building.SecurityContact;
import com.knits.ammolite.service.dto.building.SecurityContactDto;
import com.knits.ammolite.service.mapper.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SecurityContactMapper extends EntityMapper<SecurityContact,SecurityContactDto> {


}
