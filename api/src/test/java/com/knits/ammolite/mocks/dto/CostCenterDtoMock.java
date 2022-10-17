package com.knits.ammolite.mocks.dto;

import com.knits.ammolite.service.dto.company.CostCenterDto;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class CostCenterDtoMock {

    public static CostCenterDto shallowCostCenterDto(Long id) {

        return CostCenterDto.builder()
                .id(id)
                .title("Mock")
                .description("Mock description")
                .startDate(ZonedDateTime.now())
                .endDate(ZonedDateTime.of(2022, 1, 1, 0, 0, 0, 0, ZoneId.of("UTC")))
                .status("ACTIVE")
                .build();
    }
}
