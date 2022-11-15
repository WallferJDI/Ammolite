package com.knits.ammolite.mocks.dto.common;

import com.knits.ammolite.dto.common.ContactPersonDto;

public class ContactPersonDtoMock {

    public static ContactPersonDto getContactPersonDtoAllFields(Long id){
       return ContactPersonDto.builder()
                .id(id)
                .firstName("first name")
                .email("contact@mail.ee")
                .lastName("Last name")
                .jobTitle("Job")
                .phoneNumber("+3721112211")
                .note("Some note")
                .build();
    }
}
