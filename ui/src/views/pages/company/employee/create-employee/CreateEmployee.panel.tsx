import { Dispatch, SetStateAction } from "react";

import { Employee, emptyEmployee } from "@/types/domain/employee-model.type";

import { EditEmployeesPanel } from "../common/EditEmployee.panel";

interface Props {
  onSaveNewEmployee: (employee: Partial<Employee>) => void;
  navigateToPanel: Dispatch<SetStateAction<string>>;
}

export const CreateEmployeePanel = ({ onSaveNewEmployee, navigateToPanel }: Props): JSX.Element => {
  return (
    <>
      <EditEmployeesPanel
        employee={emptyEmployee}
        onSave={onSaveNewEmployee}
        title="Create New Employee"
        navigateToPanel={navigateToPanel}
      />
    </>
  );
};
