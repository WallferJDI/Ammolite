package com.knits.ammolite.repository.company;

import com.knits.ammolite.model.company.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
