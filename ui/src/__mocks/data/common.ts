export const MOCK_ID = -1000;
export const MOCK_STRING_VALUE = "A-Mock-Value-To-Be-Replaced";

export const randomIntFromInterval = (min: number, max: number): number => {
  return Math.floor(Math.random() * (max - min + 1) + min);
};
