import { BusinessUnit } from "@/types/domain/business-unit-model.type";
import { Category } from "@/types/domain/common-domain";
import { Country } from "@/types/domain/country-model.type";
import { Department } from "@/types/domain/department-model.type";
import { Email } from "@/types/domain/email-model.type";
import { Group } from "@/types/domain/group-model.type";
import { JobTitle } from "@/types/domain/job-title-model.type";
import { Team } from "@/types/domain/team-model.type";
import { SelectOption } from "@/types/ui/common-ui";

import { SELECT_ALL } from "@/common/consts";

import { FirstName } from "./../types/domain/first-name-model.type";
import { LastName } from "./../types/domain/last-name-model.type";

const categoryAsSelectionOptions = (data: Category[]): SelectOption[] => {
  const categorySelectionOptions = data.map(record => {
    return { value: `${record.id}`, label: record.name };
  });
  return [SELECT_ALL, ...categorySelectionOptions];
};

export const businessUnitsDataAsSelectOptions = (data: BusinessUnit[]): SelectOption[] => {
  return categoryAsSelectionOptions(data);
};

export const groupDataAsSelectOptions = (data: Group[]): SelectOption[] => {
  return categoryAsSelectionOptions(data);
};

export const jobTitlesDataAsSelectOptions = (data: JobTitle[]): SelectOption[] => {
  return categoryAsSelectionOptions(data);
};

export const teamDataAsSelectOptions = (data: Team[]): SelectOption[] => {
  return categoryAsSelectionOptions(data);
};

export const departmentDataAsSelectOptions = (data: Department[]): SelectOption[] => {
  return categoryAsSelectionOptions(data);
};

export const countriesDataAsSelectOptions = (data: Country[]): SelectOption[] => {
  return categoryAsSelectionOptions(data);
};
export const emailsDataAsSelectOptions = (data: Email[]): SelectOption[] => {
  return categoryAsSelectionOptions(data);
};
export const firstNamesDataAsSelectOptions = (data: FirstName[]): SelectOption[] => {
  return categoryAsSelectionOptions(data);
};
export const lastNamesDataAsSelectOptions = (data: LastName[]): SelectOption[] => {
  return categoryAsSelectionOptions(data);
};

// export const countriesDataAsSelectOptions = (countriesData: Country[]): SelectOption[] => {
//   const countryOptions = countriesData.map(country => {
//     return { value: `${country.code3}`, label: country.name };
//   });
//   return [SELECT_ALL, ...countryOptions];
// };
