package com.knits.ammolite.controller;
import com.knits.ammolite.service.mapper.EmployeeMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Captor;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class EmployeeControllerTest {
    @Spy
    private EmployeeController employeeController;

    @Captor
    private EmployeeMapper employeeMapper;

    @Test
    @DisplayName("Test getEmployeeById")
    void testGetEmployeeById() {


    }

}
