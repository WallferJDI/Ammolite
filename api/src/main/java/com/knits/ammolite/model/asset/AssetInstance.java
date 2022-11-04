package com.knits.ammolite.model.asset;


import com.knits.ammolite.model.enums.ConditionType;
import com.knits.ammolite.model.enums.Ownership;
import com.knits.ammolite.model.enums.StateType;
import com.knits.ammolite.model.enums.AssetDepreciationType;
import com.knits.ammolite.model.partner.Vendor;
import com.knits.ammolite.model.procurement.Order;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table
@Data
public class AssetInstance implements Serializable {

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
    private ConditionType condition;
    @Column
    private StateType state;
    @Column
    private AssetDepreciationType type;
    @ElementCollection(targetClass = String.class)
    @Column
    private Map<String,String> technicalSpecifications = new HashMap<>();

    @Column
    private Ownership ownership;
    @ManyToOne(fetch = FetchType.LAZY)
    private Vendor vendor;
    @OneToOne
    @JoinColumn(name = "id")
    private Order order;
    @Column
    private  Boolean depreciationAsset;
    @ManyToOne(fetch = FetchType.LAZY)
    private Depreciation depreciation;
    @ManyToOne(fetch = FetchType.LAZY)
    private Warranty warranty;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Document> documents;

    public void setDepreciationAsset(Boolean depreciationAsset) {
        this.depreciationAsset = depreciationAsset ==null?true:depreciationAsset;
    }
}
