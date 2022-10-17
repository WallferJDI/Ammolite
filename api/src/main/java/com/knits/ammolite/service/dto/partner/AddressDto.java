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
public class AddressDto {
    private Long id;
    private CountryDto country;
    private CityDto city;
    private String street;
    private String zipCode;
}
