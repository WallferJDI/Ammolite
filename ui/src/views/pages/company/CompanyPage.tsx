import { Card, CardBody, CardHeader, Container, Row } from "reactstrap";

import { BoxHeader } from "@/views/layout/headers";

export const CompanyPage = () => {
  return (
    <>
      <BoxHeader />
      <Container className="mt--6" fluid>
        <Row>
          <div className="col">
            <Card>
              <CardHeader>
                <h3 className="mb-0">Company</h3>
              </CardHeader>
              <CardBody></CardBody>
            </Card>
          </div>
        </Row>
      </Container>
    </>
  );
};
