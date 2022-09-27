import { BusinessUnit } from "@/types/domain/business-unit-model.type";
import { Group } from "@/types/domain/group-model.type";
import { Office } from "@/types/domain/office-model.type";

import { Domain } from "./common-domain";
import { Department } from "./department-model.type";
import { JobTitle } from "./job-title-model.type";

export interface Employee extends Domain {
  id: number;
  firstName: string;
  lastName: string;
  email: string;
  birthDate: string;
  gender: string;
  startDate: string;
  endDate?: string | null;
  costCenter: string;
  companyPhone: string;
  companyMobilePhone: string;
  companyCode: string;
  businessUnit?: BusinessUnit;
  department?: Department;
  manager?: Employee;
  office?: Office;
  jobTitle?: JobTitle;
  groups: Group[];
}

export interface EmployeeQuery
  extends Omit<
    Employee,
    | "firstName"
    | "lastName"
    | "companyPhone"
    | "companyMobilePhone"
    | "companyMobilePhone"
    | "gender"
    | "businessUnit"
    | "office"
    | "groups"
  > {
  lastName?: string;
  businessUnitId?: number;
  departmentId?: number;
  officeCountryId?: number;
  jobTitleId?: number;
  hiredFrom?: string;
  hiredTo?: string;
}

export const emptyEmployee: Employee = {
  id: 0,
  firstName: "",
  lastName: "",
  email: "",
  birthDate: "",
  gender: "",
  startDate: "",
  costCenter: "",
  companyPhone: "",
  companyMobilePhone: "",
  companyCode: "",
  groups: [],
};
