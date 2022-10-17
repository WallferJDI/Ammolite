package com.knits.ammolite.mocks.dto;

import com.knits.ammolite.service.dto.company.JobTitleDto;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class JobTitleDtoMock {

    public static JobTitleDto shallowJobTitleDto(Long id) {

        return JobTitleDto.builder()
                .id(id)
                .title("Mock")
                .description("Mock description")
                .startDate(ZonedDateTime.now())
                .endDate(ZonedDateTime.of(2022, 1, 1, 0, 0, 0, 0, ZoneId.of("UTC")))
                .status("ACTIVE")
                .build();
    }
}
