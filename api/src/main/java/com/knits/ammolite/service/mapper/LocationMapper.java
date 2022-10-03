package com.knits.ammolite.service.mapper;

import com.knits.ammolite.model.Country;
import com.knits.ammolite.model.Location;
import com.knits.ammolite.service.dto.CountryDto;
import com.knits.ammolite.service.dto.LocationDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LocationMapper {

   @Mapping(source = "location.country",target = "country")
   @Mapping(source = "location.ownership",target = "ownership")
   @Mapping(source = "location.realEstate",target = "realEstate")
    LocationDto toDto(Location location);

    @InheritInverseConfiguration
    Location toEntity (LocationDto locationDto);

    CountryDto toDto(Country country);

    Country toEntity (CountryDto countryDto);




}

