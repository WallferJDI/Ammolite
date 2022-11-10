package com.knits.ammolite.dto.partner;

import com.knits.ammolite.dto.common.AddressDto;
import com.knits.ammolite.dto.common.ContactPersonDto;
import com.knits.ammolite.dto.common.OrganizationDto;
import com.knits.ammolite.model.security.User;
import com.knits.ammolite.model.company.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PartnerDto {

    private Long id;
    private OrganizationDto legalData;
    private AddressDto address;
    private ContactPersonDto contact;
    private ZonedDateTime startDate;
    private ZonedDateTime endDate;
    private Status status;
    private User createdBy;
}
