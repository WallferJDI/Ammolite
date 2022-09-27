import { Employee } from "@/types/domain/employee-model.type";

export interface CreateEmployeeRequest extends Omit<Employee, "queries"> {
  id: number;
  firstName: string;
  lastName: string;
  email: string;
  costCenter: string;
  birthDate: string;
  companyPhone: string;
  companyMobilePhone: string;
  gender: string;
  startDate: string;
  endDate?: string | null;
  dateOfLeave: string | null;
}
