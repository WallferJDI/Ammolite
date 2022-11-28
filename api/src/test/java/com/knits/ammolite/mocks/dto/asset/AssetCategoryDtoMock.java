package com.knits.ammolite.mocks.dto.asset;

import com.knits.ammolite.dto.asset.AssetCategoryDto;
import com.knits.ammolite.mocks.dto.common.CategoryDtoMock;

public class AssetCategoryDtoMock {

    public static AssetCategoryDto getAllFieldsDto(Long id){
        return AssetCategoryDto.builder()
                .id(id)
                .name("Querty")
                .parentCategory(CategoryDtoMock.getAllFieldsCategoryDtoMock(id))
                .build();
    }
}
