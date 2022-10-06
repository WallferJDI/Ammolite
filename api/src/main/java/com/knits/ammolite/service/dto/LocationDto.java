package com.knits.ammolite.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LocationDto {

    private Long id;

    private String title;

    private CountryDto country;

    private String address;

    private String zipCode;

    private String ownership;

    private boolean mapCoordinates;

    private String latitude;

    private String longitude;

    private String realEstate;

    private boolean deleted;

}
