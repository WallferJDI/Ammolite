import { BusinessUnit } from "@/types/domain/business-unit-model.type";

import { randomIntFromInterval } from "./common";

export const businessUnitsData: BusinessUnit[] = [
  { id: 1, name: "Road Logistics" },
  { id: 2, name: "Air Logistics" },
  { id: 3, name: "Sea Logistics" },
  { id: 4, name: "Sales" },
  { id: 5, name: "Contract Logistics" },
  { id: 6, name: "Human Resources" },
  { id: 7, name: "QSHE" },
  { id: 8, name: "Marketing" },
  { id: 9, name: "Finance" },
  { id: 10, name: "Legal" },
  { id: 11, name: "IT" },
  { id: 12, name: "Administrative" },
  { id: 13, name: "National Management" },
];

export const randomBusinessUnit = () => {
  return businessUnitsData[randomIntFromInterval(0, businessUnitsData.length - 1)];
};
