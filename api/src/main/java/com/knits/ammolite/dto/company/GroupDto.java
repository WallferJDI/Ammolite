package com.knits.ammolite.dto.company;

import com.knits.ammolite.model.enums.Status;
import com.knits.ammolite.dto.security.UserDto;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GroupDto {
    private Long id;
    private String name;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Status status;
    private UserDto creator;
}
