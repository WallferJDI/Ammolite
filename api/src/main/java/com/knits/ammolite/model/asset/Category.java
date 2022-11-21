package com.knits.ammolite.model.asset;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;


    @Column(nullable = false,unique = true)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category parentCategory;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "parentCategory",orphanRemoval = true,fetch = FetchType.LAZY)
    private Set<Category> subcategory = new HashSet<>();


}
