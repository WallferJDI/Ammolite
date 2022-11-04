
package com.knits.ammolite.service.mapper.location;

import com.knits.ammolite.model.common.Country;
import com.knits.ammolite.service.dto.location.CountryDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CountryMapper {


    CountryDto toDto(Country country);

    Country toEntity (CountryDto countryDto);

    void update(CountryDto countryDto, @MappingTarget Country country);
}

