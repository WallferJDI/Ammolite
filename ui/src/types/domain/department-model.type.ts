import { Category } from "./common-domain";
import { Employee } from "./employee-model.type";

export interface Department extends Category {
  manager?: Employee;
  managerId?: number;
  employeeIds?: number[];
}
