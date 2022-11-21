package com.knits.ammolite.mocks.dto.asset;

import com.knits.ammolite.dto.asset.AssetDto;
import com.knits.ammolite.mocks.dto.common.CategoryDtoMock;

import java.util.HashMap;

public class AssetDtoMock {


    public static AssetDto getAllFieldAssetDtoMock(Long id){
        return AssetDto.builder()
                .id(id)
                .manufacturer("Manf")
                .description("description")
                .name("Asset name")
                .code("777-88-11")
                .category(CategoryDtoMock.getAllFieldsCategoryDtoMock(id))
                .productUrl("https://google.com/")
                .photoUrl("https://google.com/")
                .technicalSpecifications(new HashMap<>())
                .build();
    }
}
