import { Card, CardBody, CardHeader, Container } from "reactstrap";

import { BoxHeader } from "@/views/layout/headers";

export const DemoImagePanel = (): JSX.Element => {
  return (
    <>
      <BoxHeader />
      <Container className="mt--6" fluid>
        <Card className="mb-4">
          <CardHeader>
            <h3 className="mb-0">Demo Images</h3>
          </CardHeader>
          <CardBody>Images go here...</CardBody>
        </Card>
      </Container>
    </>
  );
};
