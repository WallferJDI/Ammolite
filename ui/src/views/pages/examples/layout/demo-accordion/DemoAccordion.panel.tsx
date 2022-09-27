import { Card, CardBody, CardHeader, Container } from "reactstrap";

import { BoxHeader } from "@/views/layout/headers";

export const DemoAccordionPanel = (): JSX.Element => {
  return (
    <>
      <BoxHeader />
      <Container className="mt--6" fluid>
        <Card className="mb-4">
          <CardHeader>
            <h3 className="mb-0">Demo Accordion</h3>
          </CardHeader>
          <CardBody>Accordion Demo go here...</CardBody>
        </Card>
      </Container>
    </>
  );
};
