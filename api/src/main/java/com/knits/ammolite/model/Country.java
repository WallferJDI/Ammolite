package com.knits.ammolite.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Filter;

import javax.persistence.*;
import java.util.List;
import static javax.persistence.FetchType.LAZY;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    private String title;

    @OneToMany(mappedBy = "country", fetch = LAZY)
    @Filter(name = "deletedLocationFilter", condition = "deleted = :isDeleted")
    private List<Location> locationList;

}
