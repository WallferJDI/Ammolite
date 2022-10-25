package com.knits.ammolite.service.mapper;

import com.knits.ammolite.model.building.Contact;
import com.knits.ammolite.service.dto.building.ContactDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactMapper extends EntityMapper<Contact,ContactDto> {


}
