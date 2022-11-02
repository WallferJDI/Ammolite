package com.knits.ammolite.service.dto.building;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReceptionDto {

    private Long id;

    private String fax;

    private String phone;
}
