package com.knits.ammolite.mocks.dto;

import com.knits.ammolite.service.dto.BusinessUnitDto;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class BusinessUnitDtoMock {

    public static BusinessUnitDto shallowBusinessUnitDto(Long id) {

        return BusinessUnitDto.builder()
                .id(id)
                .title("Mock")
                .description("Mock description")
                .startDate(ZonedDateTime.now())
                .endDate(ZonedDateTime.of(2022, 1, 1, 0, 0, 0, 0, ZoneId.of("UTC")))
                .status("ACTIVE")
                .createdBy(UserDtoMock.shallowUserDto(null))
                .build();
    }
}
