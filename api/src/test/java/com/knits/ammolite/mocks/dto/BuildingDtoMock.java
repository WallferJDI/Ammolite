package com.knits.ammolite.mocks.dto;

import com.knits.ammolite.dto.location.BuildingDto;
import com.knits.ammolite.model.enums.LocationUsageType;

public class BuildingDtoMock {

    public static BuildingDto shallowBuildingDto(Long id){
        return BuildingDto.builder()
                .id(id)
                //.location(new LocationDto(1l,"A mock Location",new CountryDto(),"A mock Address","A mock zipCode","OUR_PREMISES",false,"A mock Longitude","A mock Longitude","OFFICE" ,false))
                //.contact(new ContactDto(1l,"A mock Firstname","A mock Lastname","A mock Email,","A mock Phone"))
                //.security(new SecurityContactDto(1l,"A mock Firstname","A mock Lastname","A mock Email,","A mock Phone"))
                //.reception(new ReceptionDto(1l,"A mock Fax,","A mock Phone"))
                .usage(LocationUsageType.OFFICE)
                .street("A mock Address")
                .isDeleted(false)
                .build();
    }

    }
