package com.knits.ammolite.mokcs.dto;

import com.knits.ammolite.model.location.RealEstateType;
import com.knits.ammolite.service.dto.FloorDto;
import com.knits.ammolite.service.dto.building.BuildingDto;
import com.knits.ammolite.service.dto.building.ContactDto;
import com.knits.ammolite.service.dto.building.ReceptionDto;
import com.knits.ammolite.service.dto.building.SecurityContactDto;
import com.knits.ammolite.service.dto.location.CountryDto;
import com.knits.ammolite.service.dto.location.LocationDto;


public class FloorDtoMock {
    public static FloorDto shallowFloorDto(Long id){
        return FloorDto.builder()
                .id(id)
                .floorNumber("1")
                .realEstate("OFFICE")
                .building(new BuildingDto(1l,new LocationDto(1l,"A mock Location",new CountryDto(1l,"A mock Country"),"A mock Address","A mock zipCode","OFFICE",false,"A mock Longitude","A mock Longitude","OUR_PREMISES" ,false)
                        ,new ContactDto(1l,"A mock Firstname","A mock Lastname","A mock Email,","A mock Phone")
                        ,new SecurityContactDto(1l,"A mock Firstname","A mock Lastname","A mock Email,","A mock Phone")
                        ,new ReceptionDto(1l,"A mock Fax,","A mock Phone"),"OFFICE","A mock Address",false))
                .isDeleted(false)
                .build();
}}
