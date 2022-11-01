package com.knits.ammolite.mocks.dto;


import com.knits.ammolite.service.dto.JobTitleDto;

public class JobTitleDtoMock {
    public static JobTitleDto shallowJobTitleDto(Long id) {
        return JobTitleDto.builder()
                .id(id)
                .name("Job Title 1")
                .build();
    }
}
