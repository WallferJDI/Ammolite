package com.knits.ammolite.dto.company;

import com.knits.ammolite.dto.security.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CostCenterDto {

    private Long id;
    private String title;
    private String description;
    private ZonedDateTime startDate;
    private ZonedDateTime endDate;
    private String status;
    private UserDto createdBy;
}
