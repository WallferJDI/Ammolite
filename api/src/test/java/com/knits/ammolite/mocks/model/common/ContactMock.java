package com.knits.ammolite.mocks.model.common;


import com.knits.ammolite.model.common.Contact;

public class ContactMock {
    public static Contact getContactPersonAllFields(Long id){
        return Contact.builder()
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
