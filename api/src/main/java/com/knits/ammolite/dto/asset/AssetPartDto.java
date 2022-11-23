package com.knits.ammolite.dto.asset;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssetPartDto extends AssetDto {
    private Long id;
    private AssetDto parentAsset;

    public void setParentAsset(AssetDto parentAsset) {
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