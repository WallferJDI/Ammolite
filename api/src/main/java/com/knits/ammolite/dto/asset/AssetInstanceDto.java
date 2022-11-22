package com.knits.ammolite.dto.asset;

import com.fasterxml.jackson.annotation.JsonView;
import com.knits.ammolite.config.Views;
import com.knits.ammolite.dto.common.AddressDto;
import com.knits.ammolite.dto.location.LocationDto;
import com.knits.ammolite.model.enums.AssetDepreciationType;
import com.knits.ammolite.model.enums.ConditionType;
import com.knits.ammolite.model.enums.Ownership;
import com.knits.ammolite.model.enums.StateType;
import com.knits.ammolite.model.location.Location;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssetInstanceDto implements Serializable {
    @JsonView(Views.Public.class)
    private Long id;
    @JsonView(Views.Public.class)
    private AssetDto asset;
    @NotEmpty
    @NotBlank
    @JsonView(Views.Public.class)
    private String serialNumber;
    @NotEmpty
    @NotBlank
    @JsonView(Views.Public.class)
    private String tag;
    @NotEmpty
    @NotBlank
    @JsonView(Views.Public.class)
    private String barcode;
    @NotEmpty
    @NotBlank
    @JsonView(Views.Public.class)
    private String description;
    @JsonView(Views.Public.class)
    private String key;
    @JsonView(Views.Public.class)
    private ConditionType condition;
    @JsonView(Views.Public.class)
    private StateType state;
    @JsonView(Views.Public.class)
    private AssetDepreciationType type;
    @JsonView(Views.Public.class)
    private Map<String,String> technicalSpecifications = new HashMap<>();
    @JsonView(Views.Public.class)
    private Ownership ownership;
    @NotNull
    @JsonView(Views.Internal.class)
    private VendorDto vendor;
    @JsonView(Views.Internal.class)
    private OrderDto order;
    @JsonView(Views.Public.class)
    private Boolean depreciationAsset;
    @JsonView(Views.Internal.class)
    private DepreciationDto depreciation;
    @JsonView(Views.Internal.class)
    private WarrantyDto warranty;
    @JsonView(Views.Internal.class)
    private List<DocumentDto> documents;
    @NotNull
    @JsonView(Views.Internal.class)
    private AddressDto address;
}
