package com.knits.ammolite.service;

import com.knits.ammolite.mocks.dto.UserDtoMock;
import com.knits.ammolite.model.User;
import com.knits.ammolite.repository.UserRepository;
import com.knits.ammolite.service.dto.UserDto;
import com.knits.ammolite.service.mapper.UserMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Spy
    private final UserMapper userMapper = new UserMapper();

    @Captor
    private ArgumentCaptor<User> userCaptor;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;


    @Test
    @DisplayName("Save User Success")
    void saveSuccess() {

        //1) create some mock data (make them reusable in ohter tests)
        UserDto toSaveDto = UserDtoMock.shallowUserDto(null);

        //2) prepare mocks for everything they should return
        when(userRepository.save(Mockito.any(User.class))) //any object of type User will match here
                .thenAnswer(i -> i.getArguments()[0]); //echo 1st parameter received

        //3) class under test
        UserDto savedDto = userService.save(toSaveDto);

        //4) use captor in spy/mocks for everything they get as input
        verify(userRepository).save(userCaptor.capture());
        User toSaveEntity = userCaptor.getValue();

        //5) check if all dependencies were called (eventually with check on input data)
        verify(userMapper, times(1)).toEntity(toSaveDto);
        verify(userRepository, times(1)).save(toSaveEntity);
        verify(userMapper, times(1)).toDto(toSaveEntity);

        //6) assertions actual vs expected
        assertThat(toSaveDto).isEqualTo(savedDto); //not usually a good practice, but equals has override using all fields
    }

    @Test
    @DisplayName("delete success")
    void deleteSuccess (){
        Long entityIdToDelete = 1L;
        userService.delete(entityIdToDelete);
    }
}
