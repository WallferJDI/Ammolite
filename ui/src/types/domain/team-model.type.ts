import { Category } from "./common-domain";
import { Employee } from "./employee-model.type";

export interface Team extends Category {
  teamLead?: Employee;
  teamLeadId?: number;
  employeeIds: number[];
}
