package com.knits.ammolite.service;


import com.knits.ammolite.exceptions.EmployeeException;
import com.knits.ammolite.exceptions.UserException;
import com.knits.ammolite.model.company.Employee;
import com.knits.ammolite.service.dto.EmployeeDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.knits.ammolite.service.mapper.EmployeeMapper.employeeMapper;
import static com.knits.ammolite.service.mapper.EmployeeMapper.employeeRepository;

@Service
@Transactional
@Slf4j
public class EmployeeService {

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

    //Partial Update








//    public LocationDto update(LocationDto locationDto){
//        log.debug("Request to edit Location : {}", locationDto);
//        final Location locationFromDb = repository.findById(locationDto.getId()).get();
//        if ( locationFromDb.getId()==null) {
//            String message = "Location with id = " + locationDto.getId() + " does not exist.";
//            log.warn(message);
//            throw new RuntimeException(message);
//        }
//        mapper.update(locationDto,locationFromDb);
//        repository.save(locationFromDb);
//        return mapper.toDto(locationFromDb);
//    }



    @Transactional
    public EmployeeDto deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id).get();
        employeeRepository.delete(employee);
        return employeeMapper.entityToDto(employee);

    }
}


