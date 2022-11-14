export interface Person {
  id: number;
  firstName?: string;
  lastName?: string;
  email?: string;
  phone?: string;
  jobTitle?: string;
  note?: string;
}

export const emptyPerson: Person = {
  id: 0,
  firstName: "",
  lastName: "",
  email: "",
  phone: "",
  jobTitle: "",
  note: "",
};
