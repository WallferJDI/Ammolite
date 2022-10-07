package com.knits.ammolite.mokcs.dto;

import com.knits.ammolite.model.Country;
import com.knits.ammolite.model.Location;
import com.knits.ammolite.model.OwnershipType;
import com.knits.ammolite.model.RealEstateType;
import com.knits.ammolite.service.dto.CountryDto;
import com.knits.ammolite.service.dto.LocationDto;

import java.util.ArrayList;
import java.util.List;

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
