import { useState } from "react";

import { Button, Card, Container, Row } from "reactstrap";

import { SelectOption } from "@/types/ui/common-ui";

import { countries } from "@/__mocks/data/countries-mocks";
import { emails } from "@/__mocks/data/emails-mocks";
import { firstNames } from "@/__mocks/data/first-names-mocks";
import { lastNames } from "@/__mocks/data/last-names-mocks";
import {
  countriesDataAsSelectOptions,
  emailsDataAsSelectOptions,
  firstNamesDataAsSelectOptions,
  lastNamesDataAsSelectOptions,
} from "@/common/category-utils";
import { BoxHeader } from "@/views/layout/headers";

import { SearchOrganizationFilterPanel } from "./common/SearchOrganizationFilter.panel";

export const OrganizationMainPanel = (): JSX.Element => {
  const countriesData: SelectOption[] = countriesDataAsSelectOptions(countries());
  const emailsData: SelectOption[] = emailsDataAsSelectOptions(emails());
  const firstNamesData: SelectOption[] = firstNamesDataAsSelectOptions(firstNames());
  const lastNamesData: SelectOption[] = lastNamesDataAsSelectOptions(lastNames());
  const [newDataBtn, setNewDataBtn] = useState<boolean>(false);

  return (
    <>
      <BoxHeader />
      <Container className="mt--6" fluid>
        <Row>
          <Card className="mt-7 ml-3">
            <Button onClick={() => setNewDataBtn(!newDataBtn)} color="primary" type="button">
              New
            </Button>
          </Card>
        </Row>
        {newDataBtn && (
          <SearchOrganizationFilterPanel
            countries={countriesData}
            emails={emailsData}
            firstNames={firstNamesData}
            lastNames={lastNamesData}
          />
        )}
      </Container>
    </>
  );
};
