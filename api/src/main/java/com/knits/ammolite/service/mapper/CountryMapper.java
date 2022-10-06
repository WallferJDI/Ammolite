
package com.knits.ammolite.service.mapper;

import com.knits.ammolite.model.Country;
import com.knits.ammolite.model.Location;
import com.knits.ammolite.service.dto.CountryDto;
import com.knits.ammolite.service.dto.LocationDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CountryMapper {


    CountryDto toDto(Country country);

    Country toEntity (CountryDto countryDto);

    void update(CountryDto countryDto, @MappingTarget Country country);
}

