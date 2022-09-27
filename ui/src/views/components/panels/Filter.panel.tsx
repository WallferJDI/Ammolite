import { Button, Card, CardBody, CardHeader, Col, Row } from "reactstrap";

interface Props {
  title: string;
  resetFilters: () => void;
  children?: React.ReactNode;
  isSubmitting: boolean;
  onSearch?: (values: any) => void;
}

export const FilterPanel = ({ title, children, resetFilters, onSearch }: Props) => {
  return (
    <Card>
      <CardHeader>
        <h3 className="mb-0">{title}</h3>
        <p className="text-sm font-weight-400 mb-0">Filters</p>
      </CardHeader>
      <CardBody className="pl-6 pr-6">
        <Row>
          <Col>{children}</Col>
        </Row>
        <Row>
          <Col md="12">&nbsp;</Col>
        </Row>
        <Row>
          <Col md="10"></Col>
          <Col md="1">
            <Button
              className="btn btn-primary"
              style={{ width: "6rem" }}
              color="primary"
              onClick={onSearch}
              type={onSearch ? "button" : "submit"}
            >
              Search
            </Button>
          </Col>
          <Col md="1">
            <Button
              className="btn btn-secondary"
              style={{ width: "6rem" }}
              color="secondary"
              onClick={resetFilters}
            >
              Reset
            </Button>
          </Col>
        </Row>
      </CardBody>
    </Card>
  );
};
