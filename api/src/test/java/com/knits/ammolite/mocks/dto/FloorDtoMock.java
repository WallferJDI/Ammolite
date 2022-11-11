package com.knits.ammolite.mocks.dto;

import com.knits.ammolite.dto.location.FloorDto;
import com.knits.ammolite.dto.location.BuildingDto;
import com.knits.ammolite.dto.common.CountryDto;
import com.knits.ammolite.dto.location.LocationDto;


public class FloorDtoMock {
    public static FloorDto shallowFloorDto(Long id){
        return FloorDto.builder()
                .id(id)
                .floorNumber("1")
                .realEstate("OFFICE")
                .isDeleted(false)
                .build();
}}
