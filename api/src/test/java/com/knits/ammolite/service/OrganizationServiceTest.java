package com.knits.ammolite.service;

import com.knits.ammolite.model.organization.Organization;
import com.knits.ammolite.repository.CountryRepository;
import com.knits.ammolite.repository.OrganizationRepository;
import com.knits.ammolite.service.dto.OrganizationDto;
import com.knits.ammolite.service.mapper.OrganizationMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import com.knits.ammolite.payload.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;
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
        organizationMapper = new OrganizationMapper(countryService);
        underTest = new OrganizationService(organizationMapper, organizationRepository, countryService);

    }

    @Test
    void createOrganization() {
        CreateOrganizationRequest organizationRequest = new CreateOrganizationRequest();
        organizationRequest.setOrganizationName("OrgName");
        organizationRequest.setOrganizationAlias("OrgAlias");
        organizationRequest.setVAT("122-1123-34");
        organizationRequest.setRegistrationCode("2223344");
        organizationRequest.setTaxRegistrationCountry("Estonia");
        organizationRequest.setLegalAddressCountry("Italy");
        organizationRequest.setLegalAddressCity("Rome");
        organizationRequest.setLegalAddressStreet("Hire street");
        organizationRequest.setLegalAddressZipcode("204005");
        organizationRequest.setEmailContactPerson("test@gmail.com");
        organizationRequest.setFirstNameContactPerson("John");
        organizationRequest.setLastNameContactPerson("Smith");
        organizationRequest.setJobTitleContactPerson("HR");
        organizationRequest.setPhoneNumberContactPerson("+37255506216");


         underTest.createOrganization(organizationRequest);
        OrganizationDto testDto = organizationMapper.requestToDto(organizationRequest);
        Organization organization = organizationMapper.toEntity(testDto);
        ArgumentCaptor<Organization> organizationArgumentCaptor =
                ArgumentCaptor.forClass(Organization.class);

        verify(organizationRepository)
                .save(organizationArgumentCaptor.capture());
        assertThat(organizationArgumentCaptor.getValue()).isEqualTo(organization);

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

