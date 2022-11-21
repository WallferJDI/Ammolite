package com.knits.ammolite.model.asset;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "assetPart")
@Data
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AssetPart extends Asset{
    private static final long serialVersionUID = 1L;

    @ManyToOne(fetch = FetchType.LAZY)
    private Asset parentAsset;

    public void setParentAsset(Asset parentAsset) {
        this.parentAsset = parentAsset;
        super.setManufacturer(parentAsset.getManufacturer());
        super.setDescription(parentAsset.getDescription());
        super.setName(parentAsset.getName());
        super.setCode(parentAsset.getCode());
        super.setCategory(parentAsset.getCategory());
        super.setProductUrl(parentAsset.getProductUrl());
        super.setPhotoUrl(parentAsset.getPhotoUrl());
        super.setTechnicalSpecifications(parentAsset.getTechnicalSpecifications());
    }
}
