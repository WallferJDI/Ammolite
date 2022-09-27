import { faker } from "@faker-js/faker";

import { Office } from "@/types/domain/office-model.type";

import { randomIntFromInterval } from "./common";
import { countries } from "./countries-mocks";

const officeData: Office[] = [];
const howManyOffices = 30;

const createOffices = (howMany: number): Office[] => {
  const officeMockData: Office[] = [];

  for (let i = 0; i < howMany; i++) {
    const country = countries()[i];
    officeMockData.push({
      id: i + 1,
      countryId: country.id,
      countryIso2: country.iso2,
      city: faker.address.cityName(),
      street: faker.address.streetAddress(),
      country: country.name,
      postalCode: faker.address.zipCodeByState(country.iso2),
    });
  }
  return officeMockData;
};

export const offices = (): Office[] => {
  if (officeData.length == 0) {
    const calculatedOffices = createOffices(howManyOffices);
    officeData.push(...calculatedOffices);
  }
  return officeData;
};

export const randomOffice = (): Office => {
  if (officeData.length == 0) {
    offices();
  }
  return officeData[randomIntFromInterval(0, officeData.length)];
};
