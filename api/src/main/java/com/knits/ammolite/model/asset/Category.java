package com.knits.ammolite.model.asset;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Fetch(FetchMode.JOIN)
    @ManyToOne
    private Category parentCategory;

    @Fetch(FetchMode.JOIN)
    @OneToMany(cascade = CascadeType.REFRESH,mappedBy = "parentCategory",orphanRemoval = true)
    private Set<Category> subcategory = new HashSet<>();

}
