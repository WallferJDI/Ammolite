package com.knits.ammolite.service.dto.partner;

import com.knits.ammolite.model.partner.Country;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyDataDto {

    private Long id;
    private String title;
    private String alias;
    private String vatNumber;
    private String registrationCode;
    private Country taxRegistrationCountry;
}
