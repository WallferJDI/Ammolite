package com.knits.ammolite.mocks.dto.common;


import com.knits.ammolite.dto.common.ContactDto;

public class ContactDtoMock {

    public static ContactDto getContactPersonDtoAllFields(Long id){

       return ContactDto.builder()
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
