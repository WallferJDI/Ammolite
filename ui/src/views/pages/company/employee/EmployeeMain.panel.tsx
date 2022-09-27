import { useState } from "react";

import { TabContent, TabPane } from "reactstrap";

import { Employee, EmployeeQuery, emptyEmployee } from "@/types/domain/employee-model.type";
import { SelectOption } from "@/types/ui/common-ui";

import { businessUnitsData } from "@/__mocks/data/business-units-mocks";
import { countries } from "@/__mocks/data/countries-mocks";
import { departmentsData } from "@/__mocks/data/departments-mocks";
import { mockEmployees } from "@/__mocks/data/employees-mocks";
import { jobTitlesData } from "@/__mocks/data/jobTitles-mocks";
import {
  businessUnitsDataAsSelectOptions,
  countriesDataAsSelectOptions,
  departmentDataAsSelectOptions,
  jobTitlesDataAsSelectOptions,
} from "@/common/category-utils";

import { CreateEmployeePanel } from "./create-employee/CreateEmployee.panel";
import { EmployeeDetailsPanel } from "./employee-details/EmployeeDetails.panel";
import { EMPLOYEE_CREATE, EMPLOYEE_DETAILS, EMPLOYEE_SEARCH } from "./employee.routes.consts";
import { SearchEmployeesPanel } from "./search-employees/SearchEmployees.panel";

export const EmployeeMainPanel = (): JSX.Element => {
  const [activePanel, setActivePanel] = useState<string>(EMPLOYEE_SEARCH);
  const [employees, setEmployees] = useState<Employee[]>([]);
  const [currentEmployee, setCurrentEmployee] = useState<Employee>(emptyEmployee);

  const departments: SelectOption[] = departmentDataAsSelectOptions(departmentsData);
  const countriesData: SelectOption[] = countriesDataAsSelectOptions(countries());
  const businessUnits: SelectOption[] = businessUnitsDataAsSelectOptions(businessUnitsData);
  const jobtitles: SelectOption[] = jobTitlesDataAsSelectOptions(jobTitlesData);

  const onCreateNew = (newEmployee: Partial<Employee>) => {
    console.log(newEmployee);
  };

  const onSave = (partialEmployee: Partial<Employee>) => {
    console.log(partialEmployee);
    return partialEmployee;
  };

  const onViewEmployeeDetails = (id: number) => {
    const foundEmployee = employees.find(employee => employee.id === id) as Employee;
    setCurrentEmployee(foundEmployee);
    setActivePanel(EMPLOYEE_DETAILS);
  };

  const onSearchEmployees = async (employeeSearchRequest: Partial<EmployeeQuery>) => {
    console.log(employeeSearchRequest);
    //change employees according to query result
    setEmployees(mockEmployees());
  };

  const onDelete = (id: number) => {
    console.log(id);
  };

  return (
    <>
      <TabContent activeTab={activePanel}>
        <TabPane tabId={EMPLOYEE_SEARCH}>
          <SearchEmployeesPanel
            employees={employees}
            departments={departments}
            countries={countriesData}
            businessUnits={businessUnits}
            jobtitles={jobtitles}
            navigateToPanel={setActivePanel}
            onSearchEmployees={onSearchEmployees}
            onDelete={onDelete}
            onViewDetails={onViewEmployeeDetails}
          />
        </TabPane>
        <TabPane tabId={EMPLOYEE_CREATE}>
          <CreateEmployeePanel onSaveNewEmployee={onCreateNew} navigateToPanel={setActivePanel} />
        </TabPane>
        <TabPane tabId={EMPLOYEE_DETAILS}>
          <EmployeeDetailsPanel
            employee={currentEmployee}
            onSave={onSave}
            navigateToPanel={setActivePanel}
          />
        </TabPane>
      </TabContent>
    </>
  );
};
