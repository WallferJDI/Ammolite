package com.knits.ammolite.dto.location;

import com.knits.ammolite.dto.common.AddressDto;
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
    private AddressDto address;
    private String ownership;
    private boolean mapCoordinates;
    private String latitude;
    private String longitude;
    private String realEstate;
    private boolean isDeleted;

}
