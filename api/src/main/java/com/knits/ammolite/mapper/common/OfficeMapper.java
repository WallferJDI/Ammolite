package com.knits.ammolite.mapper.common;

import com.knits.ammolite.dto.common.AddressDto;
import com.knits.ammolite.dto.company.OfficeDto;
import com.knits.ammolite.model.common.Address;
import com.knits.ammolite.model.common.Office;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OfficeMapper extends EntityMapper<Office, OfficeDto>{
}
