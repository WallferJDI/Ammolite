package com.knits.ammolite.service.dto;

import lombok.Data;

@Data
public class ContactPersonDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String jobTitle;
    private String note;

}
