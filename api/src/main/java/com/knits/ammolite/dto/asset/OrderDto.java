package com.knits.ammolite.dto.asset;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderDto {
    private Long id;
    private String code;
    private LocalDateTime date;
    private Integer cost;
    private String costCenter;
    private String invoiceNumber;
}
