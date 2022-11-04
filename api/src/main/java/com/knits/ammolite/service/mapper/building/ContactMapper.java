package com.knits.ammolite.service.mapper.building;

import com.knits.ammolite.model.location.Contact;
import com.knits.ammolite.service.dto.building.ContactDto;
import com.knits.ammolite.service.mapper.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactMapper extends EntityMapper<Contact,ContactDto> {


}
