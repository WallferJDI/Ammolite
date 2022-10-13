package com.knits.ammolite.service.dto.asset;

import com.knits.ammolite.model.enums.Ownership;
import lombok.Data;

@Data
public class SourceDto {
    private Long id;
    private Ownership ownership;
    private VendorDto vendorDto;
    private OrderDto orderDto;
}
