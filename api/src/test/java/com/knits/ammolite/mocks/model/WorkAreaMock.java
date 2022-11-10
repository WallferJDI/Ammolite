package com.knits.ammolite.mocks.model;

import com.knits.ammolite.model.location.Floor;
import com.knits.ammolite.model.location.WorkArea;
import com.knits.ammolite.model.location.Building;
import com.knits.ammolite.model.common.Country;
import com.knits.ammolite.model.location.Location;

import java.util.ArrayList;
import java.util.List;

import static com.knits.ammolite.model.enums.OwnershipType.OUR_PREMISES;
import static com.knits.ammolite.model.enums.LocationUsageType.OFFICE;

public class WorkAreaMock {

    public static WorkArea shallowWorkArea(Long id){

        return WorkArea.builder()
                .id(id)
                .name("1")
                .usage(OFFICE)
                .isDeleted(false)
                .build();
    }

    public static List<WorkArea> shallowListOfWorkAreas(int howMany){
        List<WorkArea> mockWorkAreas = new ArrayList<>();
        for (int i=0;i<howMany; i++){
            mockWorkAreas.add(shallowWorkArea(Long.valueOf(i)));
        }
        return mockWorkAreas;
    }
}
