package com.knits.ammolite.controller;
import com.knits.ammolite.service.mapper.EmployeeMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Captor;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTest {
    @Spy
    private EmployeeController employeeController;

    @Captor
    private EmployeeMapper employeeMapper;
}
