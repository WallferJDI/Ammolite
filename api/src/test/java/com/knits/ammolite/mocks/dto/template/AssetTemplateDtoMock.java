package com.knits.ammolite.mocks.dto.template;

import com.knits.ammolite.dto.asset.AssetDto;
import com.knits.ammolite.dto.template.AssetTemplateDto;
import com.knits.ammolite.mocks.dto.common.CategoryDtoMock;

import java.util.HashMap;

public class AssetTemplateDtoMock {


    public static AssetTemplateDto getAllFieldAssetTemplateDtoMock(Long id){
        AssetTemplateDto assetDto = new AssetTemplateDto();
        assetDto.setId(id);
        assetDto.setManufacturer("Manf");
        assetDto.setDescription("description");
        assetDto.setName("Asset name");
        assetDto.setCode("777-88-11");
        assetDto.setCategory(CategoryDtoMock.getAllFieldsCategoryDtoMock(id));
        assetDto.setProductUrl("https://google.com/");
        assetDto.setPhotoUrl("https://google.com/");
        assetDto.setTechnicalSpecifications(new HashMap<>());
        return assetDto;
    }
}
