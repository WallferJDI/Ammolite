package com.knits.ammolite.controller;
import com.knits.ammolite.exceptions.UserException;
import com.knits.ammolite.service.EmployeeService;
import com.knits.ammolite.service.dto.employee.EmployeeDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/employees/")
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(value = "/newemployee", produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<EmployeeDto> createNewEmployee(@RequestBody EmployeeDto employeeDto) {
        log.debug("REST request to create Employee");
        checkIfNullOrEmpty(employeeDto);
        return ResponseEntity
                .ok()
                .body(employeeService.saveNewEmployee(employeeDto));
    }

    @GetMapping(value = "/employee/{id}", produces = {"application/json"})
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable(value = "id") final Long id) {
        log.debug("REST request to get Employee : {}", id);
        EmployeeDto employeeFound = employeeService.findEmployeeById(id);
        return ResponseEntity
                .ok()
                .body(employeeFound);
    }

    @PatchMapping(value = "/employee/{id}", produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable(value = "id") final Long id, @RequestBody EmployeeDto employeeDto) {
        log.debug("REST request to update Employee : {}", id);
        EmployeeDto employeeFound = employeeService.updateEmployee(id, employeeDto);
        return ResponseEntity
                .ok()
                .body(employeeFound);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable Long id) {
        boolean deleted = false; //created a flag
        deleted = employeeService.deleteEmployee(id);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted", deleted);
        return ResponseEntity.ok(response);
    }

    public void checkIfNullOrEmpty(EmployeeDto employeeDto){
        String firstName = employeeDto.getFirstName();
        String lastName = employeeDto.getLastName();
        String email = employeeDto.getEmail();
        String dateOfBirth = String.valueOf(employeeDto.getDateOfBirth());
        String gender = String.valueOf(employeeDto.getGender());
        String startDate = String.valueOf(employeeDto.getStartDate());
        String companyPhone = employeeDto.getCompanyPhone();
        String companyMobileNumber = employeeDto.getCompanyMobileNumber();
        String role = String.valueOf(employeeDto.getRoleDto());
        String businessUnit = String.valueOf(employeeDto.getBusinessUnitDto());
        String organization = String.valueOf(employeeDto.getOrganizationDto());
        String office = String.valueOf(employeeDto.getOfficeDto());
        String jobTitle = String.valueOf(employeeDto.getJobTitleDto());
        String department = String.valueOf(employeeDto.getDepartmentDto());
        String division = String.valueOf(employeeDto.getDivisionDto());
        String solidLineManager = String.valueOf(employeeDto.getSolidLineManagerDto());

        if(firstName==null||firstName.isEmpty()){
            String message = "First name is mandatory";
            log.warn(message);
            throw new UserException(message);
        } if (lastName==null||lastName.isEmpty()){
            String message = "Last name is mandatory";
            log.warn(message);
            throw new UserException(message);}
        if (dateOfBirth==null||dateOfBirth.isEmpty()){
            String message = "Date of Birth can`t be null or empty";
            log.warn(message);
            throw new UserException(message);}
        if (email==null||email.isEmpty()){
            String message = "Email is mandatory";
            log.warn(message);
            throw new UserException(message);}
        if (gender==null||gender.isEmpty()){
            String message = "Gender is mandatory";
            log.warn(message);
            throw new UserException(message);}
        if (startDate==null||startDate.isEmpty()){
            String message = "Start Date is mandatory";
            log.warn(message);
            throw new UserException(message);}
        if (companyPhone==null||companyPhone.isEmpty()){
            String message = "Comapny Phone can`t be null or empty";
            log.warn(message);
            throw new UserException(message);}
        if (companyMobileNumber==null||companyMobileNumber.isEmpty()){
            String message = "Comapny Mobile Number can`t be null or empty";
            log.warn(message);
            throw new UserException(message);}
        if (role==null||role.isEmpty()){
            String message = "Role is mandatory";
            log.warn(message);
            throw new UserException(message);}
        if (businessUnit==null||businessUnit.isEmpty()){
            String message = "Business Unit is mandatory";
            log.warn(message);
            throw new UserException(message);}
        if (organization==null||organization.isEmpty()){
            String message = "Organization is mandatory";
            log.warn(message);
            throw new UserException(message);}
        if (office==null||office.isEmpty()){
            String message = "Office is mandatory";
            log.warn(message);
            throw new UserException(message);}
        if (jobTitle==null||jobTitle.isEmpty()){
            String message = "Job Title is mandatory";
            log.warn(message);
            throw new UserException(message);}
        if (department==null||department.isEmpty()){
            String message = "Department is mandatory";
            log.warn(message);
            throw new UserException(message);}
        if (division==null||division.isEmpty()){
            String message = "Division is mandatory";
            log.warn(message);
            throw new UserException(message);}
        if (solidLineManager==null||solidLineManager.isEmpty()){
            String message = "Solid Line Manager is mandatory";
            log.warn(message);
            throw new UserException(message);}
    }
}
