package com.knits.ammolite.dto.location;

import com.knits.ammolite.dto.common.ContactDto;
import com.knits.ammolite.dto.company.OfficeDto;
import com.knits.ammolite.model.enums.LocationUsageType;
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

    private ContactDto referenceContact;

    private ContactDto securityContact;

    private LocationUsageType usage;

    private String street;

    private boolean isDeleted;

}
