package com.knits.ammolite.service.dto.partner;

import com.knits.ammolite.model.common.User;
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
    private CompanyDataDto legalData;
    private AddressDto address;
    private ContactPersonDto contact;
    private WebDto web;
    private ZonedDateTime startDate;
    private ZonedDateTime endDate;
    private Status status;
    private User createdBy;
}
