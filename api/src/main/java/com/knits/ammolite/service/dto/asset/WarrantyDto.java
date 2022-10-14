package com.knits.ammolite.service.dto.asset;

import com.knits.ammolite.model.asset.Provider;
import com.knits.ammolite.model.asset.Warranty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class WarrantyDto {
    private Long id;
    private String number;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Provider provider;
    private Byte[] file;
    private WarrantyDto template;
    private boolean fullCoverage;
    private Integer maxCoverage;
    private String description;

}
