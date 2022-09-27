import { JobTitle } from "@/types/domain/job-title-model.type";

import { randomIntFromInterval } from "./common";

export const jobTitlesData: JobTitle[] = [
  { id: 1, name: "Professor" },
  { id: 2, name: "Research Associate" },
  { id: 3, name: "Engineer IV" },
  { id: 4, name: "Account Representative III" },
  { id: 5, name: "Software Test Engineer IV" },
  { id: 6, name: "Registered Nurse" },
  { id: 7, name: "Editor" },
  { id: 8, name: "Internal Auditor" },
  { id: 9, name: "Compensation Analyst" },
  { id: 10, name: "Director of Sales" },
  { id: 11, name: "Programmer III" },
  { id: 12, name: "GIS Technical Architect" },
  { id: 13, name: "VP Quality Control" },
  { id: 14, name: "Account Executive" },
  { id: 15, name: "Legal Assistant" },
  { id: 16, name: "Account Executive" },
  { id: 17, name: "Associate Professor" },
  { id: 18, name: "Structural Analysis Engineer" },
  { id: 19, name: "Electrical Engineer" },
  { id: 20, name: "Cost Accountant" },
  { id: 21, name: "Business Systems Development Analyst" },
  { id: 22, name: "Statistician I" },
  { id: 23, name: "Compensation Analyst" },
  { id: 24, name: "Analyst Programmer" },
  { id: 25, name: "Database Administrator I" },
  { id: 26, name: "Senior Sales Associate" },
  { id: 27, name: "Teacher" },
  { id: 28, name: "Physical Therapy Assistant" },
  { id: 29, name: "Dental Hygienist" },
  { id: 30, name: "Marketing Manager" },
];

export const randomJobTitle = () => {
  return jobTitlesData[randomIntFromInterval(0, jobTitlesData.length)];
};
