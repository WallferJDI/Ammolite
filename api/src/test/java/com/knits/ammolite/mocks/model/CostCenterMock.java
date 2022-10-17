package com.knits.ammolite.mocks.model;

import com.knits.ammolite.model.company.CostCenter;
import com.knits.ammolite.model.company.Status;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class CostCenterMock {

    public static CostCenter shallowCostCenter(Long id) {
        return CostCenter.builder()
                .id(id)
                .title("Mock")
                .description("Mock description")
                .startDate(ZonedDateTime.now())
                .endDate(ZonedDateTime.of(2022, 1, 1, 0, 0, 0, 0, ZoneId.of("UTC")))
                .status(Status.ACTIVE)
                .build();
    }

    public static List<CostCenter> shallowListOfUsers(int howMany) {
        List<CostCenter> mockUsers = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            mockUsers.add(shallowCostCenter(Long.valueOf(i)));
        }
        return mockUsers;
    }
}
