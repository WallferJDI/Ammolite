package com.knits.ammolite.mapper.common;

import com.knits.ammolite.dto.common.AddressDto;
import com.knits.ammolite.model.common.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper extends EntityMapper<Address, AddressDto> {
}
