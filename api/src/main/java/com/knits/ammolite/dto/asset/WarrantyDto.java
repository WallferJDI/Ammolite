package com.knits.ammolite.dto.asset;

import com.fasterxml.jackson.annotation.JsonView;
import com.knits.ammolite.config.Views;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class WarrantyDto {
    @JsonView(Views.Public.class)
    private Long id;

    @NotEmpty
    @NotBlank
    @JsonView(Views.Public.class)
    private String number;

    @NotNull
    @JsonView(Views.Public.class)
    private LocalDateTime startDate;

    @NotNull
    @JsonView(Views.Public.class)
    private LocalDateTime endDate;

    @JsonView(Views.Public.class)
    private String provider;

    @JsonView(Views.Public.class)
    private Byte[] file;

    @JsonView(Views.Internal.class)
    private WarrantyDto template;

    @JsonView(Views.Public.class)
    private boolean fullCoverage;

    @JsonView(Views.Public.class)
    private Integer maxCoverage;

    @JsonView(Views.Public.class)
    private String description;

}
