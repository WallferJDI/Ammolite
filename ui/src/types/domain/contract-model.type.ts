import { Domain } from "./common-domain";

export interface Contract extends Domain {
  id: number;
  title: string;
  description: string;
  contentFiles: File[];
}

export interface ContractQuery extends Omit<Contract, "title" | "description" | "contentFiles"> {
  title?: string;
  description?: string;
  contentFiles?: File[];
}

export const emptyContract: Contract = {
  id: 0,
  title: "",
  description: "",
  contentFiles: [],
};
