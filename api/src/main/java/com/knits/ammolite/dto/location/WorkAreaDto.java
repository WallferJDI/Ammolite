package com.knits.ammolite.dto.location;

import com.knits.ammolite.dto.location.FloorDto;
import com.knits.ammolite.model.enums.LocationUsageType;
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
    private LocationUsageType usage;
    private FloorDto floor;
    private boolean isDeleted;
}
