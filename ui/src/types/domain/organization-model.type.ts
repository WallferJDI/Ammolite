export interface Organization {
  id: number;
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

export const emptyOrganization: Organization = {
  id: 0,
  name: "",
  alias: "",
  vatNum: "",
  regCode: "",
  taxRegCountry: "",
  legalAddressCountry: "",
  legalAddressCity: "",
  legalAddressStreet: "",
  legalAddressZipCode: "",
};
