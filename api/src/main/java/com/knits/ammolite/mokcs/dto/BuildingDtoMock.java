package com.knits.ammolite.mokcs.dto;

import com.knits.ammolite.service.dto.building.BuildingDto;
import com.knits.ammolite.service.dto.building.ContactDto;
import com.knits.ammolite.service.dto.building.ReceptionDto;
import com.knits.ammolite.service.dto.building.SecurityContactDto;
import com.knits.ammolite.service.dto.location.CountryDto;
import com.knits.ammolite.service.dto.location.LocationDto;

public class BuildingDtoMock {

    public static BuildingDto shallowBuildingDto(Long id){
        return BuildingDto.builder()
                .id(id)
                .location(new LocationDto(1l,"A mock Location",new CountryDto(),"A mock Address","A mock zipCode","OUR_PREMISES",false,"A mock Longitude","A mock Longitude","OFFICE" ,false))
                .contact(new ContactDto(1l,"A mock Firstname","A mock Lastname","A mock Email,","A mock Phone"))
                .security(new SecurityContactDto(1l,"A mock Firstname","A mock Lastname","A mock Email,","A mock Phone"))
                .reception(new ReceptionDto(1l,"A mock Fax,","A mock Phone"))
                .realEstate("OFFICE")
                .street("A mock Address")
                .isDeleted(false)
                .build();
    }

    }
