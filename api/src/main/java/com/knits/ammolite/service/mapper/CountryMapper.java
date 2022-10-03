
package com.knits.ammolite.service.mapper;

import com.knits.ammolite.model.Country;
import com.knits.ammolite.service.dto.CountryDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CountryMapper {


    CountryDto toDto(Country country);

    Country toEntity (CountryDto countryDto);
}

