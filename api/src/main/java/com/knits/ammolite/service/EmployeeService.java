package com.knits.ammolite.service;


import com.knits.ammolite.exceptions.EmployeeException;
import com.knits.ammolite.exceptions.UserException;
import com.knits.ammolite.model.employee.Employee;
import com.knits.ammolite.repository.EmployeeRepository;
import com.knits.ammolite.service.dto.employee.EmployeeDto;
import com.knits.ammolite.service.mapper.EmployeeMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private EmployeeRepository employeeRepository;


    @Transactional
    public EmployeeDto saveNewEmployee(EmployeeDto employeeDto) {

        Employee employee = employeeMapper.dtoToEntity(employeeDto);
        employeeRepository.save(employee);
        return employeeMapper.entityToDto(employee);
    }

        @Transactional
        public EmployeeDto findEmployeeById (Long id){
            Employee employee = employeeRepository.findById(id).orElseThrow(() -> new EmployeeException("User#" + id + " not found"));
            return employeeMapper.entityToDto(employee);
        }


    public EmployeeDto updateEmployee(EmployeeDto employeeDto) {
        Employee employee = employeeRepository.findById(employeeDto.getId()).orElseThrow(() -> new UserException("User#" + employeeDto.getId() + " not found"));
        employeeMapper.partialUpdate(employeeDto, employee);
        employeeRepository.save(employee);
        return employeeMapper.entityToDto(employee);
    }

    @Transactional
    public EmployeeDto deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id).get();
        employeeRepository.delete(employee);
        return employeeMapper.entityToDto(employee);

    }
}


