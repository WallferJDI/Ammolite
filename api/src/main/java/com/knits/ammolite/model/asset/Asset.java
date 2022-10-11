package com.knits.ammolite.model.asset;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Entity
@Table(name = "asset")
@Data
@Builder
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Asset  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @ManyToOne
    private Manufacturer manufacturer;

    @Column(columnDefinition = "text", nullable = false)
    private String description;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String code;

    @ManyToOne
    private Category category;

    @Column
    private URL productUrl;
    @Column
    private URL photoUrl;

    @ElementCollection(targetClass = String.class)
    @Column
    private Map<String,String> technicalSpecifications = new HashMap<>() ;

}
