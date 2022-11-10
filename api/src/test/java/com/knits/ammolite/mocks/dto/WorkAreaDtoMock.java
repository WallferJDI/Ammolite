package com.knits.ammolite.mocks.dto;

import com.knits.ammolite.dto.location.WorkAreaDto;
import com.knits.ammolite.model.enums.LocationUsageType;

public class WorkAreaDtoMock {

    public static WorkAreaDto shallowWorkAreaDto(Long id){

        return WorkAreaDto.builder()
                .id(id)
                .roomNumber("1")
                .usage(LocationUsageType.OFFICE)
            //    .floor(new FloorDto(1L,"1","OFFICE", new BuildingDto(1L,new LocationDto(1L,"A mock Location",new CountryDto(1L,"A mock Country"),"A mock Address","A mock zipCode", "OUR_PREMISES",false,"A mock Longitude","A mock Longitude", "OFFICE",false)
            //            ,new ContactDto(1L,"A mock Firstname","A mock Lastname","A mock Email,","A mock Phone")
            //            ,new SecurityContactDto(1L,"A mock Firstname","A mock Lastname","A mock Email,","A mock Phone")
            //            ,new ReceptionDto(1L,"A mock Fax,","A mock Phone"),"OFFICE", "A mock Address",false),false))
                .isDeleted(false)
                .build();
    }
}
