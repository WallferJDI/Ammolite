package com.knits.ammolite.dto.asset;

import com.fasterxml.jackson.annotation.JsonView;
import com.knits.ammolite.config.Views;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.Month;

@Data
public class DepreciationDto {
    @JsonView(Views.Public.class)
    private Long id;
    @JsonView(Views.Public.class)
    private Boolean depreciationAsset;
    @NotNull
    @JsonView(Views.Public.class)
    private LocalDateTime startDate;
    @JsonView(Views.Public.class)
    private Integer depreciableCost;
    @JsonView(Views.Public.class)
    private Integer currentValue;
    @JsonView(Views.Internal.class)
    private DepreciationDto depreciableTemplate;
    @JsonView(Views.Public.class)
    private Month lifespan;
    @JsonView(Views.Public.class)
    private Integer salvation;

}
