
package com.knits.ammolite.mapper.common;

import com.knits.ammolite.model.common.Country;
import com.knits.ammolite.dto.common.CountryDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CountryMapper extends EntityMapper<Country,CountryDto> {

}

