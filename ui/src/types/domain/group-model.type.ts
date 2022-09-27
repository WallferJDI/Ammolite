import { Employee } from "@/types/domain/employee-model.type";

import { Category } from "./common-domain";

export interface Group extends Category {
  description: string;
  active: boolean | null;
  members: Employee[];
  memberIds: number[];
}

export const emptyGroup: Group = {
  id: 0,
  name: "",
  description: "",
  active: null,
  members: [],
  memberIds: [],
};

export interface GroupMembers extends Omit<Group, "description" | "active" | "name" | "id"> {
  members: Employee[];
  memberIds: number[];
}
