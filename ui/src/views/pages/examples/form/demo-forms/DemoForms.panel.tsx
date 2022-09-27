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
import CreatableSelect from "react-select/creatable";

import {
  Card,
  CardHeader,
  CardBody,
  Label,
  FormGroup,
  Form,
  Input,
  Container,
  Row,
  Col,
  Button,
  ButtonGroup,
} from "reactstrap";

import { FileInput, SelectField } from "@/views/components/widgets";
import { BoxHeader } from "@/views/layout/headers";

import { frontendTechnologiesAsTags } from "./demo-vars";

const DemoFormsPanel = () => {
  return (
    <>
      <BoxHeader />
      <Container className="mt--6" fluid>
        <Row>
          <Col lg="6">
            <div className="card-wrapper">
              <Card>
                <CardHeader>
                  <h3 className="mb-0">HTML5 inputs</h3>
                </CardHeader>
                <CardBody>
                  <Form>
                    <FormGroup className="row">
                      <Label className="form-control-label" htmlFor="example-text-input" md="2">
                        Text
                      </Label>
                      <Col md="10">
                        <Input defaultValue="John Snow" id="example-text-input" type="text" />
                      </Col>
                    </FormGroup>
                    <FormGroup className="row">
                      <Label className="form-control-label" htmlFor="example-search-input" md="2">
                        Search
                      </Label>
                      <Col md="10">
                        <Input
                          defaultValue="Tell me your secret ..."
                          id="example-search-input"
                          type="search"
                        />
                      </Col>
                    </FormGroup>
                    <FormGroup className="row">
                      <Label className="form-control-label" htmlFor="example-email-input" md="2">
                        Email
                      </Label>
                      <Col md="10">
                        <Input
                          defaultValue="argon@example.com"
                          id="example-email-input"
                          type="email"
                        />
                      </Col>
                    </FormGroup>
                    <FormGroup className="row">
                      <Label className="form-control-label" htmlFor="example-url-input" md="2">
                        URL
                      </Label>
                      <Col md="10">
                        <Input
                          defaultValue="https://www.creative-tim.com"
                          id="example-url-input"
                          type="url"
                        />
                      </Col>
                    </FormGroup>
                    <FormGroup className="row">
                      <Label className="form-control-label" htmlFor="example-tel-input" md="2">
                        Phone
                      </Label>
                      <Col md="10">
                        <Input defaultValue="40-(770)-888-444" id="example-tel-input" type="tel" />
                      </Col>
                    </FormGroup>
                    <FormGroup className="row">
                      <Label className="form-control-label" htmlFor="example-password-input" md="2">
                        Password
                      </Label>
                      <Col md="10">
                        <Input
                          defaultValue="password"
                          id="example-password-input"
                          type="password"
                          autoComplete="off"
                        />
                      </Col>
                    </FormGroup>
                    <FormGroup className="row">
                      <Label className="form-control-label" htmlFor="example-number-input" md="2">
                        Number
                      </Label>
                      <Col md="10">
                        <Input defaultValue="23" id="example-number-input" type="number" />
                      </Col>
                    </FormGroup>
                    <FormGroup className="row">
                      <Label
                        className="form-control-label"
                        htmlFor="example-datetime-local-input"
                        md="2"
                      >
                        Datetime
                      </Label>
                      <Col md="10">
                        <Input
                          defaultValue={new Date().getFullYear() + "-11-23T10:30:00"}
                          id="example-datetime-local-input"
                          type="datetime-local"
                        />
                      </Col>
                    </FormGroup>
                    <FormGroup className="row">
                      <Label className="form-control-label" htmlFor="example-date-input" md="2">
                        Date
                      </Label>
                      <Col md="10">
                        <Input
                          defaultValue={new Date().getFullYear() + "-11-23"}
                          id="example-date-input"
                          type="date"
                        />
                      </Col>
                    </FormGroup>
                    <FormGroup className="row">
                      <Label className="form-control-label" htmlFor="example-month-input" md="2">
                        Month
                      </Label>
                      <Col md="10">
                        <Input
                          defaultValue={new Date().getFullYear() + "-11"}
                          id="example-month-input"
                          type="month"
                        />
                      </Col>
                    </FormGroup>
                    <FormGroup className="row">
                      <Label className="form-control-label" htmlFor="example-week-input" md="2">
                        Week
                      </Label>
                      <Col md="10">
                        <Input
                          defaultValue={new Date().getFullYear() + "-W23"}
                          id="example-week-input"
                          type="week"
                        />
                      </Col>
                    </FormGroup>
                    <FormGroup className="row">
                      <Label className="form-control-label" htmlFor="example-time-input" md="2">
                        Time
                      </Label>
                      <Col md="10">
                        <Input defaultValue="10:30:00" id="example-time-input" type="time" />
                      </Col>
                    </FormGroup>
                    <FormGroup className="row">
                      <Label className="form-control-label" htmlFor="example-color-input" md="2">
                        Color
                      </Label>
                      <Col md="10">
                        <Input defaultValue="#5e72e4" id="example-color-input" type="color" />
                      </Col>
                    </FormGroup>
                  </Form>
                </CardBody>
              </Card>
              <Card>
                <CardHeader>
                  <h3 className="mb-0">Button Styles</h3>
                </CardHeader>
                <CardBody>
                  <Button color="primary" type="button">
                    Button
                  </Button>
                  <Button className="btn-icon" color="primary" type="button">
                    <span className="btn-inner--icon mr-1">
                      <i className="ni ni-bag-17" />
                    </span>
                    <span className="btn-inner--text">With icon</span>
                  </Button>
                  <Button className="btn-icon" color="primary" type="button">
                    <span className="btn-inner--icon">
                      <i className="ni ni-atom" />
                    </span>
                  </Button>
                </CardBody>
              </Card>
              <Card>
                <CardHeader>
                  <h3 className="mb-0">Colors</h3>
                </CardHeader>
                <CardBody>
                  <Button color="default" type="button">
                    Default
                  </Button>
                  <Button color="primary" type="button">
                    Primary
                  </Button>
                  <Button color="secondary" type="button">
                    Secondary
                  </Button>
                  <Button color="info" type="button">
                    Info
                  </Button>
                  <Button color="success" type="button">
                    Success
                  </Button>
                  <Button color="danger" type="button">
                    Danger
                  </Button>
                  <Button color="warning" type="button">
                    Warning
                  </Button>
                </CardBody>
              </Card>

              <Card>
                <CardHeader>
                  <h3 className="mb-0">Group</h3>
                </CardHeader>
                <CardBody>
                  <ButtonGroup aria-label="Basic example" role="group">
                    <Button color="secondary" type="button">
                      Left
                    </Button>
                    <Button className="active" color="secondary" type="button">
                      Middle
                    </Button>
                    <Button color="secondary" type="button">
                      Right
                    </Button>
                  </ButtonGroup>
                  <hr />
                  <ButtonGroup>
                    <Button className="active" color="info" type="button">
                      1
                    </Button>
                    <Button color="info" type="button">
                      2
                    </Button>
                    <Button color="info" type="button">
                      3
                    </Button>
                    <Button color="info" type="button">
                      4
                    </Button>
                  </ButtonGroup>
                  <ButtonGroup>
                    <Button color="default" type="button">
                      5
                    </Button>
                    <Button color="default" type="button">
                      6
                    </Button>
                    <Button color="default" type="button">
                      7
                    </Button>
                  </ButtonGroup>
                </CardBody>
              </Card>
            </div>
          </Col>

          <Col lg="6">
            <div className="card-wrapper">
              <Card>
                <CardHeader>
                  <h3 className="mb-0">Sizes</h3>
                </CardHeader>
                <CardBody>
                  <FormGroup>
                    <label className="form-control-label" htmlFor="large-input">
                      Large input
                    </label>
                    <Input
                      id="large-input"
                      className="form-control-lg"
                      placeholder=".form-control-lg"
                      type="text"
                    />
                  </FormGroup>
                  <FormGroup>
                    <label className="form-control-label" htmlFor="default-input">
                      Default input
                    </label>
                    <Input id="default-input" placeholder="Default input" type="text" />
                  </FormGroup>
                  <FormGroup>
                    <label className="form-control-label" htmlFor="Small-input">
                      Small input
                    </label>
                    <Input
                      id="Small-input"
                      className="form-control-sm"
                      placeholder=".form-control-sm"
                      type="text"
                    />
                  </FormGroup>
                </CardBody>
              </Card>
              <Card>
                <CardHeader>
                  <h3 className="mb-0">Select</h3>
                </CardHeader>
                <CardBody>
                  <Form>
                    <FormGroup>
                      <label className="form-control-label" htmlFor="exampleFormControlSelect3">
                        Basic select ReactStrap (no style)
                      </label>
                      <br />
                      <Input
                        id="exampleFormControlSelect3"
                        type="select"
                        style={{ minWidth: "200px", maxHeight: "36px" }}
                      >
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                      </Input>
                    </FormGroup>
                    <FormGroup>
                      <label htmlFor="select-tags" className="form-control-label">
                        Creatable Select
                      </label>
                      <CreatableSelect
                        id="select-tags"
                        isMulti
                        options={frontendTechnologiesAsTags}
                        onChange={item => console.log(item)}
                      />
                    </FormGroup>
                    <SelectField
                      id="select-tags-multiple"
                      label="Multiple select"
                      value={frontendTechnologiesAsTags[0]}
                      options={frontendTechnologiesAsTags}
                      onChange={item => console.log(item)}
                      isMulti={true}
                    />

                    <SelectField
                      id="select-tags-disabled"
                      label="Disabled Selection"
                      value={frontendTechnologiesAsTags[0]}
                      options={frontendTechnologiesAsTags}
                      onChange={item => console.log(item)}
                      isDisabled={true}
                    />
                  </Form>
                </CardBody>
              </Card>
              <Card>
                <CardHeader>
                  <h3 className="mb-0">Checkboxes and radios</h3>
                </CardHeader>
                <CardBody>
                  <Form>
                    <Row>
                      <Col md="6">
                        <div className="custom-control custom-checkbox mb-3">
                          <input
                            className="custom-control-input"
                            id="customCheck1"
                            type="checkbox"
                          />
                          <label className="custom-control-label" htmlFor="customCheck1">
                            Unchecked
                          </label>
                        </div>
                        <div className="custom-control custom-checkbox mb-3">
                          <input
                            className="custom-control-input"
                            defaultChecked
                            id="customCheck2"
                            type="checkbox"
                          />
                          <label className="custom-control-label" htmlFor="customCheck2">
                            Checked
                          </label>
                        </div>
                        <div className="custom-control custom-checkbox mb-3">
                          <input
                            className="custom-control-input"
                            disabled
                            id="customCheck3"
                            type="checkbox"
                          />
                          <label className="custom-control-label" htmlFor="customCheck3">
                            Disabled Unchecked
                          </label>
                        </div>
                        <div className="custom-control custom-checkbox mb-3">
                          <input
                            className="custom-control-input"
                            defaultChecked
                            disabled
                            id="customCheck4"
                            type="checkbox"
                          />
                          <label className="custom-control-label" htmlFor="customCheck4">
                            Disabled Checked
                          </label>
                        </div>
                      </Col>
                      <Col md="6">
                        <div className="custom-control custom-radio mb-3">
                          <input
                            className="custom-control-input"
                            id="customRadio5"
                            name="custom-radio-1"
                            type="radio"
                          />
                          <label className="custom-control-label" htmlFor="customRadio5">
                            Unchecked
                          </label>
                        </div>
                        <div className="custom-control custom-radio mb-3">
                          <input
                            className="custom-control-input"
                            defaultChecked
                            id="customRadio6"
                            name="custom-radio-1"
                            type="radio"
                          />
                          <label className="custom-control-label" htmlFor="customRadio6">
                            Checked
                          </label>
                        </div>
                        <div className="custom-control custom-radio mb-3">
                          <input
                            className="custom-control-input"
                            disabled
                            id="customRadio7"
                            name="custom-radio-3"
                            type="radio"
                          />
                          <label className="custom-control-label" htmlFor="customRadio7">
                            Disabled unchecked
                          </label>
                        </div>
                        <div className="custom-control custom-radio mb-3">
                          <input
                            className="custom-control-input"
                            defaultChecked
                            disabled
                            id="customRadio8"
                            name="custom-radio-4"
                            type="radio"
                          />
                          <label className="custom-control-label" htmlFor="customRadio8">
                            Disabled checkbox
                          </label>
                        </div>
                      </Col>
                    </Row>
                  </Form>
                </CardBody>
              </Card>
              <Card>
                <CardHeader>
                  <h3 className="mb-0">File Upload</h3>
                </CardHeader>
                <CardBody>
                  <Form>
                    <div className="custom-file">
                      <FileInput
                        id="file-content-upload"
                        onChange={e => console.log(e.currentTarget.files)}
                      />
                    </div>
                  </Form>
                </CardBody>
              </Card>
            </div>
          </Col>
        </Row>
      </Container>
    </>
  );
};

export default DemoFormsPanel;
