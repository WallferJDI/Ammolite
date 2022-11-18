package com.knits.ammolite.dto.asset;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class WarrantyDto {
    private Long id;
    @NotEmpty
    @NotBlank
    private String number;
    @NotNull
    private LocalDateTime startDate;
    @NotNull
    private LocalDateTime endDate;
    private String provider;
    private Byte[] file;
    private WarrantyDto template;
    private boolean fullCoverage;
    private Integer maxCoverage;
    private String description;

}
