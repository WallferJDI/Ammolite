import { Dispatch, SetStateAction } from "react";

import { Employee } from "@/types/domain/employee-model.type";

import { EditEmployeesPanel } from "../common/EditEmployee.panel";

interface Props {
  onSave: (employee: Partial<Employee>) => void;
  navigateToPanel: Dispatch<SetStateAction<string>>;
  employee: Employee;
}

export const EmployeeDetailsPanel = ({ employee, onSave, navigateToPanel }: Props): JSX.Element => {
  return (
    <>
      <EditEmployeesPanel
        employee={employee}
        onSave={onSave}
        title="Employee Details"
        navigateToPanel={navigateToPanel}
      />
    </>
  );
};
