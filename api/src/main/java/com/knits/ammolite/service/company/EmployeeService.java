package com.knits.ammolite.service.company;


import com.knits.ammolite.dto.company.EmployeeDto;
import com.knits.ammolite.exceptions.UserException;
import com.knits.ammolite.mapper.company.EmployeeMapper;
import com.knits.ammolite.model.company.Employee;
import com.knits.ammolite.repository.company.EmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@Slf4j
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeMapper employeeMapper;
    private final EmployeeRepository employeeRepository;

    @Transactional
    public EmployeeDto saveNewEmployee(EmployeeDto employeeDto) {

        Employee employee = employeeMapper.toEntity(employeeDto);
        employeeRepository.save(employee);
        return employeeMapper.toDto(employee);
    }

        @Transactional
        public EmployeeDto findEmployeeById (Long id){
            Employee employee = employeeRepository.findById(id).orElseThrow(() -> new UserException("User#" + id + " not found"));
            return employeeMapper.toDto(employee);
        }


    public EmployeeDto updateEmployee(EmployeeDto employeeDto) {
        Employee employee = employeeRepository.findById(employeeDto.getId()).orElseThrow(() -> new UserException("User#" + employeeDto.getId() + " not found"));
        employeeMapper.partialUpdate(employee,employeeDto );
        employeeRepository.save(employee);
        return employeeMapper.toDto(employee);
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
        return employeeMapper.toDto(employee);

    }
}


