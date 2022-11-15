package com.knits.ammolite.mapper.common;

import com.knits.ammolite.dto.common.ContactDto;
import com.knits.ammolite.model.common.Contact;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactPersonMapper extends EntityMapper<Contact, ContactDto> {


}
