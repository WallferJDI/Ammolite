package com.knits.ammolite.dto.asset;

import com.knits.ammolite.model.asset.Category;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Data
public class CategoryDto {
    private Long id;
    @NotEmpty
    @NotBlank
    private String name;
    private CategoryDto parentCategory;
    @NotNull
    private Set<Category> subcategory = new HashSet<>();
}
