package com.knits.ammolite.mocks.model;

import com.knits.ammolite.model.company.Division;
import com.knits.ammolite.model.company.Status;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class DivisionMock {

    public static Division shallowDivision(Long id) {
        return Division.builder()
                .id(id)
                .title("Mock")
                .description("Mock description")
                .startDate(ZonedDateTime.now())
                .endDate(ZonedDateTime.of(2022, 1, 1, 0, 0, 0, 0, ZoneId.of("UTC")))
                .status(Status.ACTIVE)
                .build();
    }

    public static List<Division> shallowListOfUsers(int howMany) {
        List<Division> mockUsers = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            mockUsers.add(shallowDivision(Long.valueOf(i)));
        }
        return mockUsers;
    }
}
