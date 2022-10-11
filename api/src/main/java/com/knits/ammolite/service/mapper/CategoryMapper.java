package com.knits.ammolite.service.mapper;

import com.knits.ammolite.model.asset.Category;
import com.knits.ammolite.service.dto.CategoryDto;
import com.knits.ammolite.service.mapper.UserMapper;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface CategoryMapper {

    CategoryDto toDto(Category category);

    @InheritInverseConfiguration
    Category toEntity(CategoryDto categoryDto);
}
