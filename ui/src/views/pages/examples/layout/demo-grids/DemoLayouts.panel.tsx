/*!

=========================================================
* Argon Dashboard PRO React - v1.2.0
=========================================================

* Product Page: https://www.creative-tim.com/product/argon-dashboard-react
* Copyright 2021 Creative Tim (https://www.creative-tim.com)

* Coded by Creative Tim

=========================================================

* The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

*/
// reactstrap components

import { Card, CardHeader, CardBody, FormGroup, Input, Container, Row, Col } from "reactstrap";

import { BoxHeader } from "@/views/layout/headers";

const DemoLayoutsPanel = () => {
  return (
    <>
      <BoxHeader />
      <Container className="mt--6" fluid>
        <Card className="mb-4">
          <CardHeader>
            <h3 className="mb-0">Form group in grid</h3>
          </CardHeader>
          <CardBody>
            <Row>
              <Col md="4">
                <FormGroup>
                  <label className="form-control-label" htmlFor="example3cols1Input">
                    One of three cols
                  </label>
                  <Input id="example3cols1Input" placeholder="One of three cols" type="text" />
                </FormGroup>
              </Col>
              <Col md="4">
                <FormGroup>
                  <label className="form-control-label" htmlFor="example3cols2Input">
                    One of three cols
                  </label>
                  <Input id="example3cols2Input" placeholder="One of three cols" type="text" />
                </FormGroup>
              </Col>
              <Col md="4">
                <FormGroup>
                  <label className="form-control-label" htmlFor="example3cols3Input">
                    One of three cols
                  </label>
                  <Input id="example3cols3Input" placeholder="One of three cols" type="text" />
                </FormGroup>
              </Col>
            </Row>
            <Row>
              <Col md="3" sm="6">
                <FormGroup>
                  <label className="form-control-label" htmlFor="example4cols1Input">
                    One of four cols
                  </label>
                  <Input id="example4cols1Input" placeholder="One of four cols" type="text" />
                </FormGroup>
              </Col>
              <Col md="3" sm="6">
                <FormGroup>
                  <label className="form-control-label" htmlFor="example4cols2Input">
                    One of four cols
                  </label>
                  <Input id="example4cols2Input" placeholder="One of four cols" type="text" />
                </FormGroup>
              </Col>
              <Col md="3" sm="6">
                <FormGroup>
                  <label className="form-control-label" htmlFor="example4cols3Input">
                    One of four cols
                  </label>
                  <Input id="example4cols3Input" placeholder="One of four cols" type="text" />
                </FormGroup>
              </Col>
              <Col md="3" sm="6">
                <FormGroup>
                  <label className="form-control-label" htmlFor="example5cols3Input">
                    One of four cols
                  </label>
                  <Input id="example5cols3Input" placeholder="One of four cols" type="text" />
                </FormGroup>
              </Col>
            </Row>
            <Row>
              <Col md="6">
                <FormGroup>
                  <label className="form-control-label" htmlFor="example2cols1Input">
                    One of two cols
                  </label>
                  <Input id="example2cols1Input" placeholder="One of two cols" type="text" />
                </FormGroup>
              </Col>
              <Col md="6">
                <FormGroup>
                  <label className="form-control-label" htmlFor="example2cols2Input">
                    One of two cols
                  </label>
                  <Input id="example2cols2Input" placeholder="One of two cols" type="text" />
                </FormGroup>
              </Col>
            </Row>
          </CardBody>
        </Card>
      </Container>
    </>
  );
};

export default DemoLayoutsPanel;
