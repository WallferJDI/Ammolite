package com.knits.ammolite.service;

import com.knits.ammolite.model.organization.Organization;
import com.knits.ammolite.repository.CountryRepository;
import com.knits.ammolite.repository.OrganizationRepository;
import com.knits.ammolite.service.mapper.OrganizationMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class OrganizationServiceTest {

    @Mock
    private OrganizationRepository organizationRepository;
    @Mock private CountryRepository countryRepository;
    private OrganizationService underTest;
    private OrganizationMapper organizationMapper;
    private CountryService countryService;

    @BeforeEach
    void setUp(){
        countryService = new CountryService(countryRepository);
        organizationMapper = new OrganizationMapper();
        underTest = new OrganizationService(organizationMapper, organizationRepository, countryService);

    }


    @Test
    @Disabled
    void save() {

    }

    @Test
    @Disabled
    void update() {
    }
}

