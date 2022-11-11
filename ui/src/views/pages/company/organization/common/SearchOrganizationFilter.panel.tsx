import { useState } from "react";

import { Card, CardBody, CardHeader, Col, Form, FormGroup, Input, Row } from "reactstrap";

import { emptyOrganization } from "@/types/domain/organization-model.type";
import { emptyPerson } from "@/types/domain/person-model.type";
import { SelectOption } from "@/types/ui/common-ui";

import { SELECT_ALL } from "@/common/consts";
import { SelectField } from "@/views/components/widgets";

interface Props {
  countries: SelectOption[];
  emails: SelectOption[];
  firstNames: SelectOption[];
  lastNames: SelectOption[];
}

export const SearchOrganizationFilterPanel = ({
  countries,
  emails,
  firstNames,
  lastNames,
}: Props): JSX.Element => {
  const [countrySelected, setCountrySelected] = useState<SelectOption>(SELECT_ALL);
  const [emailSelected, setEmailSelected] = useState<SelectOption>(SELECT_ALL);
  const [firstNameSelected, setFirstNameSelected] = useState<SelectOption>(SELECT_ALL);
  const [lastNameSelected, setLastNameSelected] = useState<SelectOption>(SELECT_ALL);

  return (
    <>
      <Row>
        <Col lg="6">
          <div className="card-wrapper">
            <Card>
              <CardHeader>
                <h3 className="mb-0">Organization data</h3>
              </CardHeader>
              <CardBody>
                <Form>
                  <FormGroup>
                    <label
                      className="form-control-label"
                      htmlFor="company-organization-organization-name-input"
                    >
                      Organization Name
                    </label>
                    <Input
                      id="company-organization-organization-name-input"
                      placeholder="Apple"
                      type="text"
                      onChange={(event: React.ChangeEvent<HTMLInputElement>) => {
                        emptyOrganization.name = (event.target as any).value;
                      }}
                      defaultValue={emptyOrganization.name}
                    />
                  </FormGroup>
                  <FormGroup>
                    <label
                      className="form-control-label"
                      htmlFor="company-organization-organization-alias-input"
                    >
                      Organization Alias
                    </label>
                    <Input
                      id="company-organization-organization-alias-input"
                      placeholder="Apple Inc."
                      type="text"
                    />
                  </FormGroup>
                  <FormGroup>
                    <label
                      className="form-control-label"
                      htmlFor="company-organization-vat-number-input"
                    >
                      VAT number
                    </label>
                    <Input
                      id="company-organization-vat-number-input"
                      placeholder="9853241"
                      type="number"
                    />
                  </FormGroup>
                  <FormGroup>
                    <label
                      className="form-control-label"
                      htmlFor="company-organization-registration-code-input"
                    >
                      Registration Code
                    </label>
                    <Input
                      id="company-organization-registration-code-input"
                      placeholder="191823513"
                      type="number"
                    />
                  </FormGroup>
                  <FormGroup>
                    <SelectField
                      id="select-country"
                      label="Tax Registration Country"
                      value={countrySelected}
                      options={countries}
                      onChange={item => {
                        setCountrySelected(item as SelectOption);
                      }}
                    />
                  </FormGroup>
                  <FormGroup>
                    <SelectField
                      id="select-country"
                      label="Legal Address Country"
                      value={countrySelected}
                      options={countries}
                      onChange={item => {
                        setCountrySelected(item as SelectOption);
                      }}
                    />
                  </FormGroup>
                  <FormGroup>
                    <label
                      className="form-control-label"
                      htmlFor="company-organization-legal-address-city-input"
                    >
                      Legal Address City
                    </label>
                    <Input
                      id="company-organization-legal-address-city-input"
                      placeholder="Ülemiste City 25"
                      type="text"
                    />
                  </FormGroup>
                  <FormGroup>
                    <label
                      className="form-control-label"
                      htmlFor="company-organization-legal-address-street-input"
                    >
                      Legal Address Street
                    </label>
                    <Input
                      id="company-organization-legal-address-street-input"
                      placeholder="Vereni 25"
                      type="text"
                    />
                  </FormGroup>
                  <FormGroup>
                    <label
                      className="form-control-label"
                      htmlFor="company-organization-legal-address-zip-code-input"
                    >
                      Legal Address Zip Code
                    </label>
                    <Input
                      id="company-organization-legal-address-zip-code-input"
                      placeholder="36412"
                      type="number"
                    />
                  </FormGroup>
                </Form>
              </CardBody>
            </Card>
          </div>
        </Col>
        <Col lg="6">
          <div className="card-wrapper">
            <Card>
              <CardHeader>
                <h3 className="mb-0">Contact Person</h3>
              </CardHeader>
              <CardBody>
                <FormGroup>
                  <SelectField
                    id="select-first-name"
                    label="First Name"
                    value={firstNameSelected}
                    options={firstNames}
                    onChange={item => {
                      setFirstNameSelected(item as SelectOption);
                    }}
                  />
                </FormGroup>
                <FormGroup>
                  <SelectField
                    id="select-last-name"
                    label="Last Name"
                    value={lastNameSelected}
                    options={lastNames}
                    onChange={item => {
                      setLastNameSelected(item as SelectOption);
                    }}
                  />
                </FormGroup>
                <FormGroup>
                  <SelectField
                    id="select-email"
                    label="Email"
                    value={emailSelected}
                    options={emails}
                    onChange={item => {
                      setEmailSelected(item as SelectOption);
                    }}
                  />
                </FormGroup>
                <FormGroup>
                  <label className="form-control-label" htmlFor="company-person-phone-input">
                    Phone
                  </label>
                  <Input id="company-person-phone-input" placeholder="+372 5893 7700" type="tel" />
                </FormGroup>
                <FormGroup>
                  <label className="form-control-label" htmlFor="company-person-job-title-input">
                    Job Title
                  </label>
                  <Input
                    id="company-person-job-title-input"
                    placeholder="Front-End Developer"
                    type="text"
                    onChange={(event: React.ChangeEvent<HTMLInputElement>) => {
                      emptyPerson.jobTitle = (event.target as any).value;
                    }}
                    defaultValue={emptyPerson.jobTitle}
                  />
                </FormGroup>
                <FormGroup>
                  <label className="form-control-label" htmlFor="company-person-note-input">
                    Note
                  </label>
                  <Input
                    id="company-person-job-note-input"
                    placeholder="Need to check..."
                    type="text"
                  />
                </FormGroup>
              </CardBody>
            </Card>
          </div>
        </Col>
      </Row>
    </>
  );
};
