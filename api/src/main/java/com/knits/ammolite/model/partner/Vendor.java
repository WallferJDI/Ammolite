package com.knits.ammolite.model.partner;

import com.knits.ammolite.model.company.BinaryData;
import com.knits.ammolite.model.enums.DeliveryTerms;
import com.knits.ammolite.model.enums.PaymentTerms;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.EnumType.STRING;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Table(name = "vendors")
public class Vendor extends Partner {

    private static final long serialVersionUID = 2L;

    @OneToMany
    private List<BusinessCategory> businessCategories;

    @Column
    private int qualityRate;

    @Column
    private int deliveryRate;

    @Column
    private int creditLimit;

    @Enumerated(STRING)
    private DeliveryTerms deliveryTerms;

    @Enumerated(STRING)
    private PaymentTerms paymentTerms;

    @OneToMany
    private BinaryData serviceAgreement;
}
