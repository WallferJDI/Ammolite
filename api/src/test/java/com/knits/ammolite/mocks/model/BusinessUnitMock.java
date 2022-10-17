package com.knits.ammolite.mocks.model;

import com.knits.ammolite.model.company.BusinessUnit;
import com.knits.ammolite.model.company.Status;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class BusinessUnitMock {

    public static BusinessUnit shallowBusinessUnit(Long id) {
        return BusinessUnit.builder()
                .id(id)
                .title("Mock")
                .description("Mock description")
                .startDate(ZonedDateTime.now())
                .endDate(ZonedDateTime.of(2022, 1, 1, 0, 0, 0, 0, ZoneId.of("UTC")))
                .status(Status.ACTIVE)
                .build();
    }

    public static List<BusinessUnit> shallowListOfUsers(int howMany) {
        List<BusinessUnit> mockUsers = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            mockUsers.add(shallowBusinessUnit(Long.valueOf(i)));
        }
        return mockUsers;
    }
}
