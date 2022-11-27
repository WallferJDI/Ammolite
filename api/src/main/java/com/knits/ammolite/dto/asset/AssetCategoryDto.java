package com.knits.ammolite.dto.asset;

import com.knits.ammolite.dto.security.UserDto;
import com.knits.ammolite.model.company.Status;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class AssetCategoryDto {
    private Long id;
    private String name;
    private CategoryDto parentCategory;
    private ZonedDateTime startDate;
    private ZonedDateTime endDate;
    private Status status;
    private UserDto createdBy;


}
