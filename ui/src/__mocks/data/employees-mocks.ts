import { faker } from "@faker-js/faker";

import { Employee } from "@/types/domain/employee-model.type";

import { formatJsDate_DD_MM_YYYY } from "@/common/utils";

import { randomBusinessUnit } from "./business-units-mocks";
import { randomJobTitle } from "./jobTitles-mocks";
import { randomOffice } from "./offices-mocks";

const employees: Employee[] = [];
const howManyEmployees = 2000;

const createEmployees = (howMany: number): Employee[] => {
  const employeesData: Employee[] = [];

  for (let i = 0; i < howMany; i++) {
    const firstName = faker.name.firstName();
    const lastName = faker.name.lastName();
    employeesData.push({
      id: i + 1,
      firstName: firstName,
      lastName: lastName,
      email: `${firstName}.${lastName}@kuehne-nagel.com`,
      birthDate: formatJsDate_DD_MM_YYYY(faker.date.birthdate({ min: 20, max: 50 })),
      gender: faker.name.gender(true),
      startDate: formatJsDate_DD_MM_YYYY(
        faker.date.betweens("2010-01-01T00:00:00.000Z", "2020-01-01T00:00:00.000Z")[0]
      ),
      companyPhone: faker.phone.number(),
      companyMobilePhone: faker.phone.number(),
      companyCode: faker.random.alphaNumeric(7),
      costCenter: faker.random.alphaNumeric(5),
      businessUnit: randomBusinessUnit(),
      office: randomOffice(),
      jobTitle: randomJobTitle(),
      groups: [],
    });
  }

  return employeesData;
};

export const mockEmployees = (): Employee[] => {
  if (employees.length == 0) {
    const calculatedEmployees = createEmployees(howManyEmployees);
    employees.push(...calculatedEmployees);
  }
  return employees;
};
