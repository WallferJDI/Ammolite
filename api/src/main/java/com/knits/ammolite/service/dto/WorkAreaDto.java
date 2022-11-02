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
public class WorkAreaDto {

    private Long id;

    private String roomNumber;

    private String realEstate;

    private FloorDto floor;

    private boolean isDeleted;
}
