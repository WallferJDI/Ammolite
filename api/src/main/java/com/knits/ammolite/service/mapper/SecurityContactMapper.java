package com.knits.ammolite.service.mapper;

import com.knits.ammolite.model.building.SecurityContact;
import com.knits.ammolite.service.dto.building.SecurityContactDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SecurityContactMapper extends EntityMapper<SecurityContact,SecurityContactDto> {


}
