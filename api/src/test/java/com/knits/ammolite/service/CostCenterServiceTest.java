package com.knits.ammolite.service;

import com.knits.ammolite.mocks.dto.CostCenterDtoMock;
import com.knits.ammolite.mocks.model.CostCenterMock;
import com.knits.ammolite.model.company.CostCenter;
import com.knits.ammolite.repository.company.CostCenterRepository;
import com.knits.ammolite.service.company.CostCenterService;
import com.knits.ammolite.service.dto.company.CostCenterDto;
import com.knits.ammolite.service.dto.search.CostCenterSearchDto;
import com.knits.ammolite.service.mapper.company.CostCenterMapper;
import com.knits.ammolite.service.mapper.CostCenterMapperImpl;
import com.knits.ammolite.service.mapper.UserMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class CostCenterServiceTest {

    @Mock
    CostCenterRepository repository;

    @Spy
    private final CostCenterSearchDto searchDto = new CostCenterSearchDto();

    @InjectMocks
    CostCenterService service;

    @Spy
    private final CostCenterMapper mapper = new CostCenterMapperImpl();

    @Spy
    private final UserMapper userMapper = new UserMapper();

    @Captor
    private ArgumentCaptor<CostCenter> captor;

    @Test
    @DisplayName("Save BusinessUnit Success")
    void saveSuccess() {

        //1) create some mock data (make them reusable in other tests)

        CostCenterDto toSaveDto = CostCenterDtoMock.shallowCostCenterDto(null);

        //2) prepare mocks for everything they should return
        when(repository.save(Mockito.any(CostCenter.class))) //any object of type User will match here
                .thenAnswer(i -> i.getArguments()[0]); //echo 1st parameter received

        //3) class under test
        CostCenterDto savedDto = service.createCostCenter(toSaveDto);

        //4) use captor in spy/mocks for everything they get as input
        verify(repository).save(captor.capture());
        CostCenter toSaveEntity = captor.getValue();

        //5) check if all dependencies were called (eventually with check on input data)
        verify(mapper, times(1)).toEntity(toSaveDto);
        verify(repository, times(1)).save(toSaveEntity);
        verify(mapper, times(1)).toDto(toSaveEntity);

        //6) assertions actual vs expected
        assertThat(toSaveDto).isEqualTo(savedDto); //not usually a good practice, but equals has override using all fields
    }

    @Test
    @DisplayName("partial Update success")
    void partialUpdate() {

        Long entityIdToUpdate = 1L;
        String updateTitleTo = "updatedTitleOfBusinessUnit";

        CostCenter foundEntity = CostCenterMock.shallowCostCenter(entityIdToUpdate);
        CostCenterDto toUpdateDto = mapper.toDto(foundEntity); //this is recorded therefore time expected is 2
        toUpdateDto.setTitle(updateTitleTo);


        when(repository.findById(entityIdToUpdate)).thenReturn(Optional.of(foundEntity));

        CostCenterDto updatedDto = service.partialUpdate(toUpdateDto);

        verify(repository).save(captor.capture());
        CostCenter toUpdateEntity = captor.getValue();

        verify(mapper, times(1)).partialUpdate(toUpdateEntity, toUpdateDto);
        verify(repository, times(1)).save(foundEntity);
        verify(mapper, times(2)).toDto(foundEntity);

        assertThat(toUpdateDto).isEqualTo(updatedDto);
    }

    @Test
    @DisplayName("delete success")
    void deleteSuccess() {
        Long entityIdToDelete = 1L;
        service.deleteCostCenter(entityIdToDelete);
    }

}