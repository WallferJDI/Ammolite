package com.knits.ammolite.model.asset;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


@Entity
@Table(name = "asset")
@Data
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

    @Column
    private String manufacturer;

    @Column(columnDefinition = "text", nullable = false)
    private String description;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String code;

    @ManyToOne
    private Category category;

    @Column
    private String productUrl;
    @Column
    private String photoUrl;

    @ElementCollection(targetClass = String.class)
    @Column
    private Map<String,String> technicalSpecifications = new HashMap<>() ;

}
