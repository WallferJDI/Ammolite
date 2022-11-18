package com.knits.ammolite.dto.asset;

import com.knits.ammolite.dto.common.AddressDto;
import com.knits.ammolite.dto.location.LocationDto;
import com.knits.ammolite.model.enums.AssetDepreciationType;
import com.knits.ammolite.model.enums.ConditionType;
import com.knits.ammolite.model.enums.Ownership;
import com.knits.ammolite.model.enums.StateType;
import com.knits.ammolite.model.location.Location;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class AssetInstanceDto implements Serializable {
    private Long id;
    private AssetDto asset;
    @NotEmpty
    @NotBlank
    private String serialNumber;
    @NotEmpty
    @NotBlank
    private String tag;
    @NotEmpty
    @NotBlank
    private String barcode;
    @NotEmpty
    @NotBlank
    private String description;
    private String key;
    private ConditionType condition;
    private StateType state;
    private AssetDepreciationType type;
    private Map<String,String> technicalSpecifications = new HashMap<>();
    private Ownership ownership;
    @NotNull
    private VendorDto vendor;
    private OrderDto order;
    private Boolean depreciationAsset;
    private DepreciationDto depreciation;
    private WarrantyDto warranty;
    private List<DocumentDto> documents;
    @NotNull
    private AddressDto address;
}
