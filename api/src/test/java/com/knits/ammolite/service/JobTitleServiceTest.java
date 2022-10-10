package com.knits.ammolite.service;

import com.knits.ammolite.mocks.dto.JobTitleDtoMock;
import com.knits.ammolite.mocks.model.JobTitleMock;
import com.knits.ammolite.model.JobTitle;
import com.knits.ammolite.model.Status;
import com.knits.ammolite.repository.JobTitleRepository;
import com.knits.ammolite.service.dto.JobTitleDto;
import com.knits.ammolite.service.dto.search.JobTitleSearchDto;
import com.knits.ammolite.service.mapper.JobTitleMapper;
import com.knits.ammolite.service.mapper.JobTitleMapperImpl;
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
class JobTitleServiceTest {

    @Mock
    JobTitleRepository repository;

    @Spy
    private final JobTitleSearchDto searchDto = new JobTitleSearchDto();

    @InjectMocks
    JobTitleService service;

    @Spy
    private final JobTitleMapper mapper = new JobTitleMapperImpl();

    @Spy
    private final UserMapper userMapper = new UserMapper();

    @Captor
    private ArgumentCaptor<JobTitle> captor;

    @Test
    @DisplayName("Save JobTitle Success")
    void saveSuccess() {

        //1) create some mock data (make them reusable in other tests)

        JobTitleDto toSaveDto = JobTitleDtoMock.shallowJobTitleDto(null);

        //2) prepare mocks for everything they should return
        when(repository.save(Mockito.any(JobTitle.class))) //any object of type User will match here
                .thenAnswer(i -> i.getArguments()[0]); //echo 1st parameter received

        //3) class under test
        JobTitleDto savedDto = service.createJobTitle(toSaveDto);

        //4) use captor in spy/mocks for everything they get as input
        verify(repository).save(captor.capture());
        JobTitle toSaveEntity = captor.getValue();

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

        JobTitle foundEntity = JobTitleMock.shallowJobTitle(entityIdToUpdate);
        JobTitleDto toUpdateDto = mapper.toDto(foundEntity); //this is recorded therefore time expected is 2
        toUpdateDto.setTitle(updateTitleTo);


        when(repository.findById(entityIdToUpdate)).thenReturn(Optional.of(foundEntity));

        JobTitleDto updatedDto = service.partialUpdate(toUpdateDto);

        verify(repository).save(captor.capture());
        JobTitle toUpdateEntity = captor.getValue();

        verify(mapper, times(1)).partialUpdate(toUpdateEntity, toUpdateDto);
        verify(repository, times(1)).save(foundEntity);
        verify(mapper, times(2)).toDto(foundEntity);

        assertThat(toUpdateDto).isEqualTo(updatedDto);
    }

    @Test
    @DisplayName("delete success")
    void deleteSuccess() {
        Long entityIdToDelete = 1L;
        String setStatusTo = "INACTIVE";

        JobTitle foundEntity = JobTitleMock.shallowJobTitle(entityIdToDelete);
        foundEntity.setStatus(Status.valueOf(setStatusTo));

        when(repository.findById(entityIdToDelete)).thenReturn(Optional.of(foundEntity));

        service.deleteJobTitle(entityIdToDelete);

        verify(repository).save(captor.capture());
        JobTitle toDeleteEntity = captor.getValue();

        verify(repository, times(1)).save(foundEntity);

        assertThat(toDeleteEntity).isEqualTo(foundEntity);
    }
}