package com.knits.ammolite.service.dto.partner;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WebDto {

    private Long id;
    private String logoUrl;
    private String webUrl;
    private String facebook;
}
