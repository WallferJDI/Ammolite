package com.knits.ammolite.service.dto;

import com.knits.ammolite.model.Status;
import com.knits.ammolite.model.User;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TeamDto {
    private Long id;
    private String name;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Status status;
    private User creator;
}
