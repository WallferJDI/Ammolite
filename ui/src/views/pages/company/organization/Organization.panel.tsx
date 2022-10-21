import Autocomplete from "@mui/material/Autocomplete";
import Box from "@mui/material/Box";
import TextField from "@mui/material/TextField";
import { useState } from "react";

import {
  Button,
  Card,
  CardBody,
  CardHeader,
  Col,
  Container,
  Form,
  FormGroup,
  Input,
  Row,
} from "reactstrap";

import { BoxHeader } from "@/views/layout/headers";

import { addresses } from "./data/addresses";
import { countries } from "./data/countries";
import { emails } from "./data/emails";
import { firstNames } from "./data/firstnames";
import { lastNames } from "./data/lastnames";

export const OrganizationMainPanel = (): JSX.Element => {
  const [newDataBtn, setNewDataBtn] = useState<boolean>(false);

  interface Organization {
    name: string;
    alias?: string;
    vatNum: string;
    regCode: string;
    taxRegCountry: string;
    legalAddressCountry: string;
    legalAddressCity: string;
    legalAddressStreet: string;
    legalAddressZipCode: string;
  }

  interface Person {
    firstName?: string;
    lastName?: string;
    email?: string;
    phone?: string;
    jobTitle?: string;
    note?: string;
  }

  const [organization, setOrganization] = useState<Organization>({
    name: "",
    alias: "",
    vatNum: "",
    regCode: "",
    taxRegCountry: "",
    legalAddressCountry: "",
    legalAddressCity: "",
    legalAddressStreet: "",
    legalAddressZipCode: "",
  });

  const [person, setPerson] = useState<Person>({
    firstName: "",
    lastName: "",
    email: "",
    phone: "",
    jobTitle: "",
    note: "",
  });

  console.log(organization);
  console.log(person);
  return (
    <>
      <BoxHeader />
      <Container className="mt--6" fluid>
        <Row>
          <Card className="mt-7 ml-3">
            <Button onClick={() => setNewDataBtn(!newDataBtn)} color="primary" type="button">
              New
            </Button>
          </Card>
        </Row>
        {newDataBtn && (
          <Row>
            <Col lg="6">
              <div className="card-wrapper">
                <Card>
                  <CardHeader>
                    <h3 className="mb-0">Organization data:</h3>
                  </CardHeader>
                  <CardBody>
                    <Form>
                      <FormGroup>
                        <label
                          className="form-control-label"
                          htmlFor="company-organization-organization-name-input"
                        >
                          Organization Name:
                        </label>
                        <Input
                          id="company-organization-organization-name-input"
                          placeholder="Apple"
                          type="text"
                          onChange={(event: React.ChangeEvent<HTMLInputElement>) => {
                            let updatedValue = {};
                            updatedValue = { name: (event.target as any).value };
                            setOrganization(organization => ({
                              ...organization,
                              ...updatedValue,
                            }));
                          }}
                          defaultValue={organization.name}
                        />
                      </FormGroup>
                      <FormGroup>
                        <label
                          className="form-control-label"
                          htmlFor="company-organization-organization-alias-input"
                        >
                          Organization Alias:
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
                          VAT number:
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
                          Registration Code:
                        </label>
                        <Input
                          id="company-organization-registration-code-input"
                          placeholder="191823513"
                          type="number"
                        />
                      </FormGroup>
                      <FormGroup>
                        <label
                          className="form-control-label"
                          htmlFor="company-organization-tax-registration-country-input"
                        >
                          Tax Registration Country:
                        </label>
                        <Autocomplete
                          id="country-select"
                          options={countries}
                          autoHighlight
                          getOptionLabel={option => option.label}
                          renderOption={(props, option) => (
                            <Box
                              component="li"
                              sx={{ "& > img": { mr: 2, flexShrink: 0 } }}
                              {...props}
                            >
                              {option.label}
                            </Box>
                          )}
                          renderInput={params => (
                            <TextField
                              {...params}
                              label="Choose a country"
                              inputProps={{
                                ...params.inputProps,
                                autoComplete: "new-password", // disable autocomplete and autofill
                              }}
                            />
                          )}
                        />
                      </FormGroup>
                      <FormGroup>
                        <label
                          className="form-control-label"
                          htmlFor="company-organization-legal-address-country-input"
                        >
                          Legal Address Country:
                        </label>
                        <Autocomplete
                          id="address-select"
                          options={addresses}
                          autoHighlight
                          getOptionLabel={option => option.id}
                          renderOption={(props, option) => (
                            <Box
                              component="li"
                              sx={{ "& > img": { mr: 2, flexShrink: 0 } }}
                              {...props}
                            >
                              {option.id}
                            </Box>
                          )}
                          renderInput={params => (
                            <TextField
                              {...params}
                              label="Choose an address"
                              inputProps={{
                                ...params.inputProps,
                                autoComplete: "new-password", // disable autocomplete and autofill
                              }}
                            />
                          )}
                        />
                      </FormGroup>
                      <FormGroup>
                        <label
                          className="form-control-label"
                          htmlFor="company-organization-legal-address-city-input"
                        >
                          Legal Address City:
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
                          Legal Address Street:
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
                          Legal Address Zip Code:
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
                    <h3 className="mb-0">Contact Person:</h3>
                  </CardHeader>
                  <CardBody>
                    <FormGroup>
                      <label
                        className="form-control-label"
                        htmlFor="company-person-first-name-input"
                      >
                        First Name:
                      </label>
                      <Autocomplete
                        id="person-select"
                        options={firstNames}
                        autoHighlight
                        getOptionLabel={option => option.firstName}
                        renderOption={(props, option) => (
                          <Box
                            component="li"
                            sx={{ "& > img": { mr: 2, flexShrink: 0 } }}
                            {...props}
                          >
                            {option.firstName}
                          </Box>
                        )}
                        renderInput={params => (
                          <TextField
                            onChange={(event: React.ChangeEvent<HTMLInputElement>) => {
                              let updatedValue = {};
                              updatedValue = { firstName: (event.target as any).value };
                              setPerson(person => ({
                                ...person,
                                ...updatedValue,
                              }));
                            }}
                            defaultValue={person}
                            {...params}
                            label="Choose a first name"
                            inputProps={{
                              ...params.inputProps,
                              autoComplete: "new-password", // disable autocomplete and autofill
                            }}
                          />
                        )}
                      />
                    </FormGroup>
                    <FormGroup>
                      <label
                        className="form-control-label"
                        htmlFor="company-person-last-name-input"
                      >
                        Last Name:
                      </label>
                      <Autocomplete
                        id="person-select"
                        options={lastNames}
                        autoHighlight
                        getOptionLabel={option => option.lastName}
                        renderOption={(props, option) => (
                          <Box
                            component="li"
                            sx={{ "& > img": { mr: 2, flexShrink: 0 } }}
                            {...props}
                          >
                            {option.lastName}
                          </Box>
                        )}
                        renderInput={params => (
                          <TextField
                            {...params}
                            label="Choose a last name"
                            inputProps={{
                              ...params.inputProps,
                              autoComplete: "new-password", // disable autocomplete and autofill
                            }}
                          />
                        )}
                      />
                    </FormGroup>
                    <FormGroup>
                      <label className="company-person-email-input" htmlFor="default-input">
                        Email:
                      </label>
                      <Autocomplete
                        id="address-select"
                        options={emails}
                        autoHighlight
                        getOptionLabel={option => option.email}
                        renderOption={(props, option) => (
                          <Box
                            component="li"
                            sx={{ "& > img": { mr: 2, flexShrink: 0 } }}
                            {...props}
                          >
                            {option.email}
                          </Box>
                        )}
                        renderInput={params => (
                          <TextField
                            {...params}
                            label="Choose an address"
                            inputProps={{
                              ...params.inputProps,
                              autoComplete: "new-password", // disable autocomplete and autofill
                            }}
                          />
                        )}
                      />
                    </FormGroup>
                    <FormGroup>
                      <label className="form-control-label" htmlFor="company-person-phone-input">
                        Phone:
                      </label>
                      <Input
                        id="company-person-phone-input"
                        placeholder="+372 5893 7700"
                        type="tel"
                      />
                    </FormGroup>
                    <FormGroup>
                      <label
                        className="form-control-label"
                        htmlFor="company-person-job-title-input"
                      >
                        Job Title:
                      </label>
                      <Input
                        id="company-person-job-title-input"
                        placeholder="Front-End Developer"
                        type="text"
                      />
                    </FormGroup>
                    <FormGroup>
                      <label className="form-control-label" htmlFor="company-person-note-input">
                        Note:
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
        )}
      </Container>
    </>
  );
};
