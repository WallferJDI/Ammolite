import { Department } from "@/types/domain/department-model.type";

import { randomIntFromInterval } from "./common";

export const departmentsData: Department[] = [
  { id: 1, name: "Road Logistics EMEA" },
  { id: 2, name: "Road Logistics Australia" },
  { id: 3, name: "Road Logistics AMER" },
  { id: 4, name: "Road Logistics Africa" },

  { id: 5, name: "Air Logistics EMEA" },
  { id: 6, name: "Air Logistics Australia" },
  { id: 7, name: "Air Logistics AMER" },
  { id: 8, name: "Air Logistics Africa" },

  { id: 9, name: "Sea Logistics EMEA" },
  { id: 10, name: "Sea Logistics Australia" },
  { id: 11, name: "Sea Logistics AMER" },
  { id: 12, name: "Sea Logistics Africa" },

  { id: 13, name: "Contract Logistics EMEA" },
  { id: 14, name: "Contract Logistics Australia" },
  { id: 15, name: "Contract Logistics AMER" },
  { id: 16, name: "Contract Logistics Africa" },

  { id: 17, name: "Energy EMEA" },
  { id: 18, name: "Energy Australia" },
  { id: 19, name: "Energy AMER" },
  { id: 20, name: "Energy Africa" },

  { id: 21, name: "Pharma EMEA" },
  { id: 22, name: "Pharma Australia" },
  { id: 23, name: "Pharma AMER" },
  { id: 24, name: "Pharma Africa" },

  { id: 25, name: "Aeromobile EMEA" },
  { id: 26, name: "Aeromobile Australia" },
  { id: 27, name: "Aeromobile AMER" },
  { id: 28, name: "Aeromobile Africa" },

  { id: 29, name: "Automotive EMEA" },
  { id: 30, name: "Automotive Australia" },
  { id: 31, name: "Automotive AMER" },
  { id: 32, name: "Automotive Africa" },

  { id: 33, name: "Hi Tech EMEA" },
  { id: 34, name: "Hi Tech Australia" },
  { id: 35, name: "Hi Tech AMER" },
  { id: 36, name: "Hi Tech Africa" },

  { id: 37, name: "Perishable EMEA" },
  { id: 38, name: "Perishable Australia" },
  { id: 39, name: "Perishable AMER" },
  { id: 30, name: "Perishable Africa" },
];

export const randomDepartment = () => {
  return departmentsData[randomIntFromInterval(0, 39)];
};
