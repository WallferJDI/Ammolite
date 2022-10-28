package com.knits.ammolite.service.dto;

import com.knits.ammolite.service.dto.building.BuildingDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FloorDto {

    private Long id;

    private String floorNumber;

    private String realEstate;

    private BuildingDto building;

    private boolean isDeleted;
}
