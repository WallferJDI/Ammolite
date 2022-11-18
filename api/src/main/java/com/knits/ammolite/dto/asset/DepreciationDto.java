package com.knits.ammolite.dto.asset;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.Month;

@Data
public class DepreciationDto {
    private Long id;
    private Boolean depreciationAsset;
    @NotNull
    private LocalDateTime startDate;
    private Integer depreciableCost;
    private Integer currentValue;
    private DepreciationDto depreciableTemplate;
    private Month lifespan;
    private Integer salvation;

}
