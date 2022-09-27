import { faker } from "@faker-js/faker";

import { Contract } from "@/types/domain/contract-model.type";

const contracts: Contract[] = [];
const howManyContracts = 2000;

const createContracts = (howMany: number): Contract[] => {
  const contractsData: Contract[] = [];

  for (let i = 0; i < howMany; i++) {
    const title = faker.name.jobTitle();
    const description = faker.commerce.productDescription();
    contractsData.push({
      id: i + 1,
      title,
      description,
      contentFiles: [],
    });
  }

  return contractsData;
};

export const mockContracts = (): Contract[] => {
  if (contracts.length == 0) {
    const calculatedContracts = createContracts(howManyContracts);
    contracts.push(...calculatedContracts);
  }
  return contracts;
};
