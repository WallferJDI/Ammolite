import { Domain } from "./common-domain";

export interface Office extends Domain {
  id: number;
  countryId: number;
  countryIso2: string;
  city: string;
  street: string;
  country: string;
  postalCode: string;
}
