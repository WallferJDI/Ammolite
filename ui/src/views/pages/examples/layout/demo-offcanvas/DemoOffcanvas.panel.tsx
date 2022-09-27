import { Card, CardBody, CardHeader, Container } from "reactstrap";

import { BoxHeader } from "@/views/layout/headers";

export const DemoOffcanvasPanel = (): JSX.Element => {
  return (
    <>
      <BoxHeader />
      <Container className="mt--6" fluid>
        <Card className="mb-4">
          <CardHeader>
            <h3 className="mb-0">Demo Offcanvas</h3>
          </CardHeader>
          <CardBody>Offcanvas goes here...</CardBody>
        </Card>
      </Container>
    </>
  );
};
