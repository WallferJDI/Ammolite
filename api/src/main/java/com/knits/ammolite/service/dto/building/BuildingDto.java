package com.knits.ammolite.service.dto.building;

import com.knits.ammolite.service.dto.location.LocationDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BuildingDto {

    private Long id;

    private LocationDto location;

    private ContactDto contact;

    private SecurityContactDto security;

    private ReceptionDto reception;

    private boolean isDeleted;

}
