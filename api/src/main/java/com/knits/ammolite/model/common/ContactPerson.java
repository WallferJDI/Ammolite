package com.knits.ammolite.model.common;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "contact_person")
@Data
@NoArgsConstructor
public class ContactPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String email;

    @Column
    private String phoneNumber;

    @Column
    private String jobTitle;

    @Column
    private String note;
}
