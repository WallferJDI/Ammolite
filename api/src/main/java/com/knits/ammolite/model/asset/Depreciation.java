package com.knits.ammolite.model.asset;

import com.knits.ammolite.model.enums.DepreciationMethod;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Date;

@Entity
@Data
public class Depreciation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;
    @Column
    private  Boolean depreciationAsset;
    @Column(nullable = false)
    private LocalDateTime startDate;
    @Column
    private Integer depreciableCost;
    @Column
    private Integer currentValue;
    @Fetch(FetchMode.JOIN)
    @OneToOne(cascade = CascadeType.REFRESH)
    private Depreciation depreciableTemplate;
    @Column
    private Month lifespan;
    @Column
    private DepreciationMethod depreciationMethod;
    @Column
    private Integer salvation;

    public void setDepreciationAsset(Boolean depreciationAsset) {
        this.depreciationAsset = depreciationAsset ==null?true:depreciationAsset;
    }
}
