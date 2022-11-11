package com.knits.ammolite.mocks.dto;

import com.knits.ammolite.dto.company.DivisionDto;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DivisionDtoMock {

    public static DivisionDto shallowDivisionDto(Long id) {

        return DivisionDto.builder()
                .id(id)
                .title("Mock")
                .description("Mock description")
                .startDate(ZonedDateTime.now())
                .endDate(ZonedDateTime.of(2022, 1, 1, 0, 0, 0, 0, ZoneId.of("UTC")))
                .status("ACTIVE")
                .build();
    }
}
