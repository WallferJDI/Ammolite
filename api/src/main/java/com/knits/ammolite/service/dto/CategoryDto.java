package com.knits.ammolite.service.dto;

import com.knits.ammolite.model.asset.Category;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class CategoryDto {
    private Long id;
    private String name;
    private Category parentCategory;
    private Set<Category> subcategory = new HashSet<>();
}
