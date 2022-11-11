package com.knits.ammolite.dto.location;

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
