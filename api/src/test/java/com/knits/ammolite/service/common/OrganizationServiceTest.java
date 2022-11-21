package com.knits.ammolite.service.common;

import com.knits.ammolite.dto.common.OrganizationDto;
import com.knits.ammolite.mapper.common.OrganizationMapper;
import com.knits.ammolite.mapper.common.OrganizationMapperImpl;
import com.knits.ammolite.mocks.dto.common.OrganizationDtoMock;
import com.knits.ammolite.mocks.model.common.OrganizationMock;
import com.knits.ammolite.model.common.Organization;
import com.knits.ammolite.repository.common.OrganizationRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Optional;
import java.util.Random;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class OrganizationServiceTest {


    @Mock
    private OrganizationRepository repository;
    @Spy
    private OrganizationMapper mapper = new OrganizationMapperImpl();
    @InjectMocks
    private OrganizationService organizationService;
    @Mock
    private CountryService countryService;
    @Captor
    private ArgumentCaptor<Organization> captor;

    @Test
    @DisplayName("Save Organization Success")
    void save() {
        OrganizationDto inputOrganizationDto = OrganizationDtoMock.getAllFieldsOrganizationDto(new Random().nextLong());
        when(repository.save(Mockito.any(Organization.class))).thenAnswer(element ->   element.getArguments()[0]);

        OrganizationDto outputOrgDto = organizationService.save(inputOrganizationDto);

        verify(repository).save(captor.capture());
        Organization toSaveEntity = captor.getValue();

        verify(mapper,times(1)).toEntity(inputOrganizationDto);
        verify(repository,times(1)).save(toSaveEntity);
        verify(mapper,times(1)).toDto(toSaveEntity);

        assertThat(inputOrganizationDto).isEqualTo(outputOrgDto);
    }



    @Test
    @DisplayName("partial Update success")
    void partialUpdate() {
        Long entityIdToUpdate = 1L;
        String updateName = "updated Org name";

        Organization inputOrganization = OrganizationMock.getAllFieldsOrganization(entityIdToUpdate);
        OrganizationDto updateOrgDto = mapper.toDto(inputOrganization);
        updateOrgDto.setName(updateName);

        when(repository.findById(entityIdToUpdate)).thenReturn(Optional.of(inputOrganization));

        OrganizationDto outputDto = organizationService.partialUpdate(updateOrgDto);

        verify(repository).save(captor.capture());
        Organization toUpdateEntity = captor.getValue();


        verify(mapper,times(1)).partialUpdate(toUpdateEntity,updateOrgDto);
        verify(repository,times(1)).save(inputOrganization);
        verify(mapper,times(2)).toDto(inputOrganization);

        assertThat(updateOrgDto).isEqualTo(outputDto);

    }

    @Test
    @DisplayName("delete success")
    void delete() {
        Long entityIdToDelete = 1L;
        Organization foundEntity = OrganizationMock.getAllFieldsOrganization(entityIdToDelete);
        OrganizationDto toDeleteDto = mapper.toDto(foundEntity);
        when(repository.findById(entityIdToDelete)).thenReturn(Optional.of(foundEntity));
        organizationService.delete(entityIdToDelete);
        verify(repository,times(1)).deleteById(entityIdToDelete);
    }
}