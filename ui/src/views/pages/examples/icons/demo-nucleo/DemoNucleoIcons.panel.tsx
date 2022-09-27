import { Card, CardBody, CardHeader, Col, Container, NavItem, NavLink, Row } from "reactstrap";

import { BoxHeader } from "@/views/layout/headers";

const nucleoIconsNamesRows = [
  "active-40",
  "air-baloon",
  "album-2",
  "align-center",
  "align-left-2",
  "ambulance",

  "app",
  "archive-2",
  "atom",
  "badge",
  "bag-17",
  "basket",

  "bell-55",
  "bold-down",
  "bold-left",
  "bold-right",
  "bold-up",
  "bold",

  "book-bookmark",
  "books",
  "box-2",
  "briefcase-24",
  "building",
  "bulb-61",

  "bullet-list-67",
  "bus-front-12",
  "button-pause",
  "button-play",
  "button-power",
  "calendar-grid-58",

  "camera-compact",
  "caps-small",
  "cart",
  "chart-bar-32",
  "chart-pie-35",
  "chat-round",

  "credit-card",
  "circle-08",
  "cloud-download-95",
  "cloud-upload-96",
  "compass-04",
  "controller",
];
const nucleoIconsNamesRow1 = nucleoIconsNamesRows.splice(0, 6);
const nucleoIconsNamesRow2 = nucleoIconsNamesRows.splice(6, 12);
const nucleoIconsNamesRow3 = nucleoIconsNamesRows.splice(12, 18);
const nucleoIconsNamesRow4 = nucleoIconsNamesRows.splice(18, 24);
const nucleoIconsNamesRow5 = nucleoIconsNamesRows.splice(24, 30);
const nucleoIconsNamesRow6 = nucleoIconsNamesRows.splice(30, 36);
const nucleoIconsNamesRow7 = nucleoIconsNamesRows.splice(36, 42);

const renderNucleoIconAsButton = (nucleoName: string): JSX.Element => {
  const nucleoNameAsClass = `ni ni-${nucleoName}`;
  return (
    <Col lg="2" key={nucleoName}>
      <button className="btn-icon-clipboard" type="button">
        <div>
          <i className={nucleoNameAsClass} />
          <span>{nucleoName}</span>
        </div>
      </button>
    </Col>
  );
};

export const DemoNucleoIconsPanel = (): JSX.Element => {
  return (
    <>
      <BoxHeader />
      <Container className="mt--6" fluid>
        <Card className="mb-4">
          <CardHeader>
            <h3 className="mb-0">Demo Nucleo Icons</h3>
          </CardHeader>
          <CardBody>
            <Row className="justify-content-center">
              {nucleoIconsNamesRow1.map(nucleoName => renderNucleoIconAsButton(nucleoName))}
            </Row>
            <Row className="justify-content-center">
              {nucleoIconsNamesRow2.map(nucleoName => renderNucleoIconAsButton(nucleoName))}
            </Row>
            <Row className="justify-content-center">
              {nucleoIconsNamesRow3.map(nucleoName => renderNucleoIconAsButton(nucleoName))}
            </Row>
            <Row className="justify-content-center">
              {nucleoIconsNamesRow4.map(nucleoName => renderNucleoIconAsButton(nucleoName))}
            </Row>
            <Row className="justify-content-center">
              {nucleoIconsNamesRow5.map(nucleoName => renderNucleoIconAsButton(nucleoName))}
            </Row>
            <Row className="justify-content-center">
              {nucleoIconsNamesRow6.map(nucleoName => renderNucleoIconAsButton(nucleoName))}
            </Row>
            <Row className="justify-content-center">
              {nucleoIconsNamesRow7.map(nucleoName => renderNucleoIconAsButton(nucleoName))}
            </Row>
            <NavItem>
              <NavLink
                href="https://demos.creative-tim.com/argon-design-system/docs/foundation/icons.html"
                target="_blank"
              >
                {"   "} Find more icons here (Argon template)
              </NavLink>
            </NavItem>
          </CardBody>
        </Card>
      </Container>
    </>
  );
};
