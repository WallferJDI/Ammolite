package com.knits.ammolite.model.asset;


import com.knits.ammolite.model.enums.Condition;
import com.knits.ammolite.model.enums.State;
import com.knits.ammolite.model.enums.Type;
import lombok.Data;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table
@Data
public class AssetInstance {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @ManyToOne
    private Asset asset;
    @Column(nullable = false)
    private String serialNumber;
    @Column(nullable = false)
    private String tag;
    @Column(nullable = false)
    private String barcode;
    @Column(nullable = false)
    private String description;
    @Column
    private String key;
    @Column
    private Condition condition;
    @Column
    private State state;
    @Column
    private Type type;
    @ElementCollection(targetClass = String.class)
    @Column
    private Map<String,String> technicalSpecifications = new HashMap<>();
    @ManyToOne(cascade = CascadeType.ALL)
    private Source source;
    @ManyToOne(cascade = CascadeType.ALL)
    private Depreciation depreciation;
    @ManyToOne(cascade = CascadeType.ALL)
    private Warranty warranty;
}
