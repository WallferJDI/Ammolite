package com.knits.ammolite.dto.asset;

import com.knits.ammolite.annotations.ValidURL;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AssetPartDto implements Serializable {
    private Long id;
    private String manufacturer;
    private String description;
    private String name;
    private String code;
    private CategoryDto category;
    @ValidURL
    private String productUrl;
    @ValidURL
    private String photoUrl;
    private Map<String,String> technicalSpecifications = new HashMap<>() ;
    private AssetDto parentAsset;
}