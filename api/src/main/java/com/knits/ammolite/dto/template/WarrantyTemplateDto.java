package com.knits.ammolite.dto.template;

import com.fasterxml.jackson.annotation.JsonView;
import com.knits.ammolite.config.Views;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WarrantyTemplateDto {
    @JsonView(Views.Public.class)
    private Long id;

    @JsonView(Views.Public.class)
    private Boolean fullCoverage;

    @JsonView(Views.Public.class)
    private BigDecimal maxCoverage;

    @JsonView(Views.Public.class)
    private String description;
}
