package com.knits.ammolite.dto.asset;

import com.fasterxml.jackson.annotation.JsonView;
import com.knits.ammolite.config.Views;
import com.knits.ammolite.dto.template.WarrantyTemplateDto;
import com.knits.ammolite.model.template.WarrantyTemplate;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
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
    private WarrantyTemplateDto template;

    @JsonView(Views.Public.class)
    private boolean fullCoverage;

    @JsonView(Views.Public.class)
    private BigDecimal maxCoverage;

    @JsonView(Views.Public.class)
    private String description;

}
