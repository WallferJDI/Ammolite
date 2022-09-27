import { useState } from "react";

import {
  Button,
  Card,
  CardBody,
  CardHeader,
  Col,
  Container,
  FormGroup,
  Row,
  TabContent,
  TabPane,
} from "reactstrap";

import { BoxHeader } from "@/views/layout/headers";

import { COMPANY_ANALYTICS_MAIN } from "./analytics/company-analytics.routes.consts";
import { CompanyAnalyticsMainPanel } from "./analytics/CompanyAnalyticsMain.panel";
import { BUSINESS_UNIT_MAIN } from "./business-unit/business-unit.routes.consts";
import { BusinessUnitMainPanel } from "./business-unit/BusinessUnitMain.panel";
import { DEPARTMENT_MAIN } from "./department/department.routes.consts";
import { DepartmentMainPanel } from "./department/DepartmentMain.panel";
import { EMPLOYEE_MAIN } from "./employee/employee.routes.consts";
import { EmployeeMainPanel } from "./employee/EmployeeMain.panel";
import { GROUP_MAIN } from "./group/group.routes.consts";
import { GroupMainPanel } from "./group/GroupsMain.panel";
import { JOB_TITLE_MAIN } from "./job-title/job-title.routes.consts";
import { JobTitleMainPanel } from "./job-title/JobTitleMain.panel";
import { OrganizationMainPanel } from "./organization/Organization.panel";
import { ORGANIZATION_MAIN } from "./organization/organization.routes.consts";
import { SetupMainPanel } from "./setup/Setup.panel";
import { SETUP_MAIN } from "./setup/setup.routes.consts";
import { TeamMainPanel } from "./team/Team.panel";
import { TEAM_MAIN } from "./team/team.routes.consts";

export const CompanyPage = (): JSX.Element => {
  const [activeTab, setActiveTab] = useState(EMPLOYEE_MAIN);

  return (
    <>
      <BoxHeader />
      <Container className="mt--6" fluid>
        <Row>
          <div className="col">
            <Card>
              <CardHeader>
                <h3 className="mb-0">Company</h3>
              </CardHeader>
              <CardBody>
                <Row>
                  <Col lg="1">&nbsp;</Col>
                  <Col lg="11" className="d-flex flex-column justify-content-end">
                    <FormGroup>
                      <Button
                        color="primary"
                        type="submit"
                        onClick={() => setActiveTab(SETUP_MAIN)}
                      >
                        Setup
                      </Button>
                      <Button
                        color="primary"
                        type="submit"
                        onClick={() => setActiveTab(ORGANIZATION_MAIN)}
                      >
                        Organizations
                      </Button>
                      <Button
                        color="primary"
                        type="submit"
                        onClick={() => setActiveTab(JOB_TITLE_MAIN)}
                      >
                        Job Titles
                      </Button>
                      <Button
                        color="primary"
                        type="submit"
                        onClick={() => setActiveTab(EMPLOYEE_MAIN)}
                      >
                        Employees
                      </Button>
                      <Button
                        color="primary"
                        type="submit"
                        onClick={() => setActiveTab(BUSINESS_UNIT_MAIN)}
                      >
                        Business Units
                      </Button>
                      <Button
                        color="primary"
                        type="submit"
                        onClick={() => setActiveTab(DEPARTMENT_MAIN)}
                      >
                        Departments
                      </Button>
                      <Button
                        color="primary"
                        type="submit"
                        onClick={() => setActiveTab(GROUP_MAIN)}
                      >
                        Groups
                      </Button>
                      <Button color="primary" type="submit" onClick={() => setActiveTab(TEAM_MAIN)}>
                        Teams
                      </Button>
                      <Button
                        color="primary"
                        type="submit"
                        onClick={() => setActiveTab(COMPANY_ANALYTICS_MAIN)}
                      >
                        Analytics
                      </Button>
                    </FormGroup>
                  </Col>
                </Row>
              </CardBody>

              <TabContent activeTab={activeTab}>
                <TabPane tabId={SETUP_MAIN}>
                  <SetupMainPanel />
                </TabPane>
                <TabPane tabId={EMPLOYEE_MAIN}>
                  <EmployeeMainPanel />
                </TabPane>
                <TabPane tabId={ORGANIZATION_MAIN}>
                  <OrganizationMainPanel />
                </TabPane>
                <TabPane tabId={JOB_TITLE_MAIN}>
                  <JobTitleMainPanel />
                </TabPane>
                <TabPane tabId={BUSINESS_UNIT_MAIN}>
                  <BusinessUnitMainPanel />
                </TabPane>
                <TabPane tabId={DEPARTMENT_MAIN}>
                  <DepartmentMainPanel />
                </TabPane>
                <TabPane tabId={GROUP_MAIN}>
                  <GroupMainPanel />
                </TabPane>
                <TabPane tabId={TEAM_MAIN}>
                  <TeamMainPanel />
                </TabPane>
                <TabPane tabId={COMPANY_ANALYTICS_MAIN}>
                  <CompanyAnalyticsMainPanel />
                </TabPane>
              </TabContent>
            </Card>
          </div>
        </Row>
      </Container>
    </>
  );
};
