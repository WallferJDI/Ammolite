package com.knits.ammolite.mocks.model.common;


import com.knits.ammolite.model.common.ContactPerson;

public class ContactPersonMock {
    public static ContactPerson getContactPersonAllFields(Long id){
        return ContactPerson.builder()
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
