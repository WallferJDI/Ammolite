import { Card, CardBody, CardHeader, Container, Button, Row, Col } from "reactstrap";

import { alerts } from "@/views/components/feedback";
import { BoxHeader } from "@/views/layout/headers";

export const DemoAlertsPanel = (): JSX.Element => {
  const onSuccess = () => {
    alerts.successAlert("Elements saved with success", "Congratulations");
  };

  const onError = () => {
    alerts.errorAlert("User not logged", "Attention!");
  };

  const onDanger = () => {
    alerts.warningAlert("Not all elements were saved with success", "Attention");
  };

  const onConfirmationSuccess = () => {
    alerts.confirmActionSuccess("Elements saved with success", "Congratulations");
  };
  const onConfirmationError = () => {
    alerts.confirmActionAlert("User not logged", "Attention!");
  };
  const onConfirmationDanger = () => {
    alerts.confirmActionDanger("Not all elements were saved with success", "Attention");
  };

  return (
    <>
      <BoxHeader />
      <Container className="mt--6" fluid>
        <Card className="mb-4">
          <CardHeader>
            <h3 className="mb-0">Alert Demo Panel</h3>
          </CardHeader>
          <CardBody>
            <Row>
              <Col lg="3"></Col>
              <Col lg="6">
                <Button color="success" type="button" onClick={onSuccess}>
                  Success
                </Button>
                <Button color="danger" type="button" onClick={onError}>
                  Error
                </Button>
                <Button color="warning" type="button" onClick={onDanger}>
                  Warning
                </Button>
                <Button color="success" type="button" onClick={onConfirmationSuccess}>
                  Confirm
                </Button>
                <Button color="danger" type="button" onClick={onConfirmationError}>
                  Confirm
                </Button>
                <Button color="warning" type="button" onClick={onConfirmationDanger}>
                  Confirm
                </Button>
              </Col>
              <Col lg="3"></Col>
            </Row>
          </CardBody>
        </Card>
      </Container>
    </>
  );
};
