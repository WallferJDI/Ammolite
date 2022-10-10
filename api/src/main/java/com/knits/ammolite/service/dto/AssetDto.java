package com.knits.ammolite.service.dto;

import com.knits.ammolite.model.asset.Category;
import com.knits.ammolite.model.asset.Manufacturer;
import lombok.Data;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Data
public class AssetDto {
    private Long id;
    private Manufacturer manufacturer;
    private String description;
    private String name;
    private String code;
    private Category category;
    private URL productUrl;
    private URL photoUrl;
    private Map<String,String> technicalSpecifications = new HashMap<>() ;

}
