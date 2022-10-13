package com.knits.ammolite.service.dto.asset;

import com.knits.ammolite.service.dto.CategoryDto;
import com.knits.ammolite.service.dto.ManufacturerDto;
import lombok.Data;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Data
public class AssetDto {
    private Long id;
    private ManufacturerDto manufacturer;
    private String description;
    private String name;
    private String code;
    private CategoryDto category;
    private URL productUrl;
    private URL photoUrl;
    private Map<String,String> technicalSpecifications = new HashMap<>() ;

}
