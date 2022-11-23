package com.knits.ammolite.dto.asset;

import com.fasterxml.jackson.annotation.JsonView;
import com.knits.ammolite.annotations.ValidURL;
import com.knits.ammolite.config.Views;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssetDto {
    @JsonView(Views.Public.class)
    private Long id;
    @NotEmpty
    @NotBlank
    @JsonView(Views.Public.class)
    private String manufacturer;
    @NotEmpty
    @NotBlank
    @JsonView(Views.Public.class)
    private String description;
    @NotEmpty
    @NotBlank
    @JsonView(Views.Public.class)
    private String name;
    @NotEmpty
    @NotBlank
    @JsonView(Views.Public.class)
    private String code;
    @NotNull
    @JsonView(Views.Internal.class)
    private CategoryDto category;
    @JsonView(Views.Public.class)
    @ValidURL
    private String productUrl;
    @JsonView(Views.Public.class)
    @ValidURL
    private String photoUrl;
    @JsonView(Views.Public.class)
    private Map<String,String> technicalSpecifications = new HashMap<>() ;

}
