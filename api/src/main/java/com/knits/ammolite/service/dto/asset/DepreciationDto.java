package com.knits.ammolite.service.dto.asset;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.Month;

@Data
public class DepreciationDto {
    private Long id;
    private  boolean depreciationAsset;
    private LocalDateTime startDate;
    private Integer depreciableCost;
    private Integer currentValue;
    private DepreciationDto depreciableTemplate;
    private Month lifespan;
    private Integer salvation;

}
