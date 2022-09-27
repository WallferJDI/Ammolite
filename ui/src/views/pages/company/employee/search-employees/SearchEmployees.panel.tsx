import { Dispatch, MouseEvent, SetStateAction } from "react";

import { Button, Card, CardHeader, Col, Container, FormGroup, Row } from "reactstrap";

import { Employee, EmployeeQuery } from "@/types/domain/employee-model.type";
import { SelectOption } from "@/types/ui/common-ui";

import { ReactTable } from "@/views/components/widgets";
import { BoxHeader } from "@/views/layout/headers";

import { SearchEmployeesFilterPanel } from "../common/SearchEmployeesFilter.panel";
import { EMPLOYEE_CREATE } from "../employee.routes.consts";

import { employeesTableColumns } from "./SearchEmployees.table";

interface Props {
  employees: Employee[];
  departments: SelectOption[];
  countries: SelectOption[];
  businessUnits: SelectOption[];
  jobtitles: SelectOption[];
  navigateToPanel: Dispatch<SetStateAction<string>>;
  onSearchEmployees: (employeeSearchRequest: Partial<EmployeeQuery>) => void;
  onDelete: (id: number) => void;
  onViewDetails: (id: number) => void;
}

export const SearchEmployeesPanel = ({
  employees,
  departments,
  countries,
  businessUnits,
  jobtitles,
  navigateToPanel,
  onSearchEmployees,
  onDelete,
  onViewDetails,
}: Props): JSX.Element => {
  const onViewEmployeeDetails = (e: MouseEvent<HTMLButtonElement>) => {
    e.preventDefault();
    const { id } = e.currentTarget;
    onViewDetails(parseInt(id));
  };

  const onDeleteEmployee = async (e: MouseEvent<HTMLButtonElement>) => {
    e.preventDefault();
    const { id } = e.currentTarget;
    onDelete(parseInt(id));
  };

  const onCreateNewEmployee = async (e: MouseEvent<HTMLButtonElement>) => {
    e.preventDefault();
    navigateToPanel(EMPLOYEE_CREATE);
  };

  return (
    <>
      <BoxHeader />
      <Container className="mt--6" fluid>
        <Row>
          <div className="col">
            <SearchEmployeesFilterPanel
              departments={departments}
              businessUnits={businessUnits}
              countries={countries}
              jobtitles={jobtitles}
              onSearch={onSearchEmployees}
            />
          </div>
        </Row>

        <div className="col">
          <Card>
            <CardHeader>
              <Row>
                <Col md="1.1">
                  <h3 className="mb-0">Employees</h3>
                  <p className="text-sm mb-0">Employees from PDM</p>
                </Col>
              </Row>
              <Row>
                <Col md="11"></Col>
                <Col md="1">
                  <FormGroup>
                    <Button
                      className="btn btn-primary"
                      style={{ width: "6rem" }}
                      color="primary"
                      onClick={onCreateNewEmployee}
                    >
                      New
                    </Button>
                  </FormGroup>
                </Col>
              </Row>
            </CardHeader>
            <ReactTable
              data={employees}
              columns={employeesTableColumns({
                onDetailsButtonClick: onViewEmployeeDetails,
                onRemoveButtonClick: onDeleteEmployee,
              })}
            />
          </Card>
        </div>
      </Container>
    </>
  );
};
