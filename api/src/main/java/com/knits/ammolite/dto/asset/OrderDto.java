package com.knits.ammolite.dto.asset;

import com.fasterxml.jackson.annotation.JsonView;
import com.knits.ammolite.config.Views;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonView(Views.Public.class)
public class OrderDto {
    private Long id;
    private String code;
    private LocalDateTime date;
    private Integer cost;
    private String costCenter;
    private String invoiceNumber;
}
