package com.knits.ammolite.dto.asset;

import com.fasterxml.jackson.annotation.JsonView;
import com.knits.ammolite.config.Views;
import com.knits.ammolite.model.asset.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    @JsonView(Views.Public.class)
    private Long id;
    @NotEmpty
    @NotBlank
    @JsonView(Views.Public.class)
    private String name;
    @JsonView(Views.Internal.class)
    private CategoryDto parentCategory;
    @NotNull
    @JsonView(Views.Internal.class)
    private Set<Category> subcategory = new HashSet<>();
}
