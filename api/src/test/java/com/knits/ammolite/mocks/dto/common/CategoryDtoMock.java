package com.knits.ammolite.mocks.dto.common;

import com.knits.ammolite.dto.asset.CategoryDto;

import java.util.HashSet;


public class CategoryDtoMock {

    public static CategoryDto getAllFieldsCategoryDtoMock(Long id){
        return CategoryDto.builder()
                .id(id)
                .name("Names category")
                .subcategory(new HashSet<>())
                .build();
    }

    public static CategoryDto getSubcategoryDtoMock(Long id){
        return CategoryDto.builder()
                .id(id)
                .name("Sub")
                .parentCategory(getAllFieldsCategoryDtoMock(id+1))
                .subcategory(new HashSet<>())
                .build();
    }


}
