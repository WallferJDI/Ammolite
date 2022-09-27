import { Card, CardBody, CardHeader, Container } from "reactstrap";

import { BoxHeader } from "@/views/layout/headers";

export const SetupMainPanel = (): JSX.Element => {
  return (
    <>
      <BoxHeader />
      <Container className="mt--6" fluid>
        <Card className="mb-4">
          <CardHeader>
            <h3 className="mb-0">Setup</h3>
          </CardHeader>
          <CardBody>Setup Steps go here...</CardBody>
        </Card>
      </Container>
    </>
  );
};
