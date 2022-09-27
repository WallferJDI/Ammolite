import { Card, CardBody, CardHeader, Container } from "reactstrap";

import { BoxHeader } from "@/views/layout/headers";

export const DemoBadgePanel = (): JSX.Element => {
  return (
    <>
      <BoxHeader />
      <Container className="mt--6" fluid>
        <Card className="mb-4">
          <CardHeader>
            <h3 className="mb-0">Demo Badge</h3>
          </CardHeader>
          <CardBody>Badge go here...</CardBody>
        </Card>
      </Container>
    </>
  );
};
