package com.knits.ammolite.service.dto.asset;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class WarrantyDto {
    private Long id;
    private String number;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String provider;
    private Byte[] file;
    private WarrantyDto template;
    private boolean fullCoverage;
    private Integer maxCoverage;
    private String description;

}
