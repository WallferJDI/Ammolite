package com.knits.ammolite.mokcs.dto;

import com.knits.ammolite.service.dto.location.CountryDto;
import com.knits.ammolite.service.dto.location.LocationDto;

public class LocationDtoMock {

    public static LocationDto shallowLocationDto(Long id){

        return LocationDto.builder()
                .id(id)
                .title("A mock Title")
                .country(new CountryDto(1l,"A mock Country"))
                .address("A mock Address")
                .zipCode("A mock zipCode")
                .mapCoordinates(false)
                .latitude("A mock Latitude")
                .longitude("A mock Longitude")
                .ownership("OUR_PREMISES")
                .realEstate("OFFICE")
                .isDeleted(false)
                .build();
    }

}
