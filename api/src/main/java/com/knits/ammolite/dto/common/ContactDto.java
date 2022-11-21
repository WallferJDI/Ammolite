package com.knits.ammolite.dto.common;

import com.fasterxml.jackson.annotation.JsonView;
import com.knits.ammolite.config.Views;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonView(Views.Public.class)
public class ContactDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String jobTitle;
    private String note;

}
