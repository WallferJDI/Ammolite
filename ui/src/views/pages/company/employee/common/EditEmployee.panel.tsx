import { Dispatch, MouseEvent, SetStateAction, useEffect, useState } from "react";

import { Button, Card, CardBody, CardHeader, Col, Form, Row } from "reactstrap";

import { Employee } from "@/types/domain/employee-model.type";

import { InputField } from "@/views/components/widgets";

import { EMPLOYEE_SEARCH } from "../employee.routes.consts";

interface Props {
  onSave: (employee: Partial<Employee>) => void;
  navigateToPanel: Dispatch<SetStateAction<string>>;
  employee: Employee;
  title: string;
}

export const EditEmployeesPanel = ({
  onSave,
  navigateToPanel,
  employee,
  title,
}: Props): JSX.Element => {
  console.log("IN EditEmployeesPanel ", employee);

  const [employeeUi, setEmployeeUi] = useState<Employee>(employee);

  useEffect(() => {
    setEmployeeUi(employee);
  }, [employee]);

  const onSaveUiEvent = (e: MouseEvent<HTMLButtonElement>) => {
    e.preventDefault();
    onSave(employee);
  };

  const onResetUiEvent = (e: MouseEvent<HTMLButtonElement>) => {
    e.preventDefault();
    onSave(employee);
  };

  return (
    <>
      <Row>
        <Col className="order-xl-1" xl="12">
          <Card>
            <CardHeader>
              <Row className="align-items-center">
                <Col xs="8">
                  <h3 className="mb-0">{title}</h3>
                </Col>
              </Row>
              <Row className="align-items-center py-4">
                <Col lg="12" xs="7" className="text-right">
                  <Button
                    className="btn btn-primary"
                    color="primary"
                    onClick={() => navigateToPanel(`${EMPLOYEE_SEARCH}`)}
                  >
                    Back to Search
                  </Button>
                </Col>
              </Row>
            </CardHeader>
            <CardBody>
              <Form>
                <h6 className="heading-small text-muted mb-4">User information</h6>
                <div className="pl-lg-4">
                  <Row>
                    <Col lg="6">
                      <InputField
                        id="input-first-name"
                        label="First name"
                        value={employeeUi.firstName || ""}
                        type="text"
                        onChange={e =>
                          setEmployeeUi({
                            ...employeeUi,
                            firstName: e.target.value,
                          })
                        }
                      />
                    </Col>
                    <Col lg="6">
                      <InputField
                        id="input-last-name"
                        label="Last name"
                        value={employeeUi.lastName || ""}
                        type="text"
                        onChange={e =>
                          setEmployeeUi({
                            ...employeeUi,
                            lastName: e.target.value,
                          })
                        }
                      />
                    </Col>
                  </Row>
                </div>
                <div className="pl-4 d-flex justify-content-end">
                  <Button color="primary" type="submit" onClick={onSaveUiEvent}>
                    Save
                  </Button>
                  <Button color="primary" type="submit" onClick={onResetUiEvent}>
                    Reset
                  </Button>
                </div>
              </Form>
            </CardBody>
          </Card>
        </Col>
      </Row>
    </>
  );
};
