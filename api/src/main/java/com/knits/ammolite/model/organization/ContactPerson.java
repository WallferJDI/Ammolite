package com.knits.ammolite.model.organization;

import com.knits.ammolite.annotations.ValidEmail;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "contactPerson")
@Data
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
    @ValidEmail
    private String email;

    @Column
    private String phoneNumber;

    @Column
    private String jobTitle;

    @Column
    private String note;

}
