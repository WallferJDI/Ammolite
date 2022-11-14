package com.knits.ammolite.mapper.common;

import com.knits.ammolite.dto.common.ContactPersonDto;
import com.knits.ammolite.model.common.ContactPerson;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactPersonMapper extends EntityMapper<ContactPerson, ContactPersonDto> {


}
