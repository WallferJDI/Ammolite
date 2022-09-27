import {
  BsBoxSeam,
  BsBuilding,
  BsBullseye,
  BsBookmarkHeart,
  BsBoundingBox,
  BsClipboardCheck,
} from "react-icons/bs";
import { DiAndroid, DiAtom, DiDocker, DiLinux, DiReact, DiWindows } from "react-icons/di";
import { FaAmazon, FaApple, FaAws, FaBeer, FaGithub, FaJava } from "react-icons/fa";
import {
  TiAnchor,
  TiDeviceDesktop,
  TiGlobeOutline,
  TiThermometer,
  TiThSmallOutline,
  TiWiFi,
} from "react-icons/ti";

import {
  Card,
  CardBody,
  CardHeader,
  CardTitle,
  Col,
  Container,
  NavItem,
  NavLink,
  Row,
} from "reactstrap";

import { BoxHeader } from "@/views/layout/headers";

export const DemoReactIconsPanel = (): JSX.Element => {
  return (
    <>
      <BoxHeader />
      <Container className="mt--6" fluid>
        <Card className="mb-4">
          <CardHeader>
            <h3 className="mb-0">Demo React Icons</h3>
          </CardHeader>
          <CardBody>
            <CardTitle> Fontawesome icons</CardTitle>
            <CardBody>
              <Row className="justify-content-center">
                <Col lg="2">
                  <button className="btn-icon-clipboard" type="button">
                    <FaBeer />
                    <p className="text-primary">FaBeer</p>
                  </button>
                </Col>
                <Col lg="2">
                  <button className="btn-icon-clipboard" type="button">
                    <FaApple />
                    <p className="text-primary">FaApple</p>
                  </button>
                </Col>
                <Col lg="2">
                  <button className="btn-icon-clipboard" type="button">
                    <FaAws />
                    <p className="text-primary">FaAws</p>
                  </button>
                </Col>
                <Col lg="2">
                  <button className="btn-icon-clipboard" type="button">
                    <FaAmazon />
                    <p className="text-primary">FaAmazon</p>
                  </button>
                </Col>
                <Col lg="2">
                  <button className="btn-icon-clipboard" type="button">
                    <FaGithub />
                    <p className="text-primary">FaGithub</p>
                  </button>
                </Col>
                <Col lg="2">
                  <button className="btn-icon-clipboard" type="button">
                    <FaJava /> <p className="text-primary">FaJava</p>
                  </button>
                </Col>
              </Row>
            </CardBody>
            <CardTitle> Bootstrap Icons icons</CardTitle>
            <CardBody>
              <Row className="justify-content-center">
                <Col lg="2">
                  <button className="btn-icon-clipboard" type="button">
                    <BsBoxSeam />
                    <p>BsBoxSeam</p>
                  </button>
                </Col>
                <Col lg="2">
                  <button className="btn-icon-clipboard" type="button">
                    <BsBuilding />
                    <p>BsBuilding</p>
                  </button>
                </Col>
                <Col lg="2">
                  <button className="btn-icon-clipboard" type="button">
                    <BsBullseye />
                    <p>BsBullseye</p>
                  </button>
                </Col>
                <Col lg="2">
                  <button className="btn-icon-clipboard" type="button">
                    <BsBookmarkHeart />
                    <p>BsBookmarkHeart</p>
                  </button>
                </Col>
                <Col lg="2">
                  <button className="btn-icon-clipboard" type="button">
                    <BsBoundingBox />
                    <p>BsBoundingBox</p>
                  </button>
                </Col>
                <Col lg="2">
                  <button className="btn-icon-clipboard" type="button">
                    <BsClipboardCheck />
                    <p>BsClipboardCheck</p>
                  </button>
                </Col>
              </Row>
            </CardBody>
            <CardTitle> Devicons Icons icons</CardTitle>
            <CardBody>
              <Row className="justify-content-center">
                <Col lg="2">
                  <button className="btn-icon-clipboard" type="button">
                    <DiAndroid />
                    <p>DiAndroid</p>
                  </button>
                </Col>
                <Col lg="2">
                  <button className="btn-icon-clipboard" type="button">
                    <DiAtom />
                    <p>DiAtom</p>
                  </button>
                </Col>
                <Col lg="2">
                  <button className="btn-icon-clipboard" type="button">
                    <DiDocker />
                    <p>DiDocker</p>
                  </button>
                </Col>
                <Col lg="2">
                  <button className="btn-icon-clipboard" type="button">
                    <DiLinux /> <p>DiLinux</p>
                  </button>
                </Col>
                <Col lg="2">
                  <button className="btn-icon-clipboard" type="button">
                    <DiWindows /> <p>DiWindows</p>
                  </button>
                </Col>
                <Col lg="2">
                  <button className="btn-icon-clipboard" type="button">
                    <DiReact /> <p>DiReact</p>
                  </button>
                </Col>
              </Row>
            </CardBody>
            <CardTitle> Typicons Icons icons</CardTitle>
            <CardBody>
              <Row className="justify-content-center">
                <Col lg="2">
                  <button className="btn-icon-clipboard" type="button">
                    <TiAnchor />
                    <p>TiAnchor</p>
                  </button>
                </Col>
                <Col lg="2">
                  <button className="btn-icon-clipboard" type="button">
                    <TiDeviceDesktop />
                    <p>TiDeviceDesktop</p>
                  </button>
                </Col>
                <Col lg="2">
                  <button className="btn-icon-clipboard" type="button">
                    <TiGlobeOutline />
                    <p>TiGlobeOutline</p>
                  </button>
                </Col>
                <Col lg="2">
                  <button className="btn-icon-clipboard" type="button">
                    <TiThermometer />
                    <p>TiThermometer</p>
                  </button>
                </Col>
                <Col lg="2">
                  <button className="btn-icon-clipboard" type="button">
                    <TiWiFi />
                    <p>TiWiFi</p>
                  </button>
                </Col>
                <Col lg="2">
                  <button className="btn-icon-clipboard" type="button">
                    <TiThSmallOutline />
                    <p>TiThSmallOutline</p>
                  </button>
                </Col>
              </Row>
            </CardBody>
            <NavItem>
              <NavLink href="https://react-icons.github.io/react-icons" target="_blank">
                {"   "} Find many more icons here
              </NavLink>
            </NavItem>
          </CardBody>
        </Card>
      </Container>
    </>
  );
};
