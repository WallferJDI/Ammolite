package com.knits.ammolite.dto.common;

import lombok.Data;

@Data
public class ContactDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String jobTitle;
    private String note;

}
