import { useState } from "react";

import {
  Card,
  CardBody,
  CardHeader,
  Col,
  Container,
  Dropdown,
  DropdownItem,
  DropdownMenu,
  DropdownToggle,
  FormGroup,
  Row,
  TabContent,
  TabPane,
} from "reactstrap";

import { BoxHeader } from "@/views/layout/headers";

import { DemoAlertsPanel } from "./form/demo-alerts/DemoAlerts.panel";
import DemoFormsPanel from "./form/demo-forms/DemoForms.panel";
import { DemoModalPanel } from "./form/demo-modal/DemoModal.panel";
import { DemoNucleoIconsPanel } from "./icons/demo-nucleo/DemoNucleoIcons.panel";
import { DemoReactIconsPanel } from "./icons/demo-react-icons/DemoReactIcons.panel";
import { DemoAccordionPanel } from "./layout/demo-accordion/DemoAccordion.panel";
import { DemoCardsPanel } from "./layout/demo-cards/DemoCards.panel";
import DemoLayoutsPanel from "./layout/demo-grids/DemoLayouts.panel";
import { DemoOffcanvasPanel } from "./layout/demo-offcanvas/DemoOffcanvas.panel";
import { DemoComparePanel } from "./pages/demo-compare/DemoCompare.panel";
import { DemoProfilePanel } from "./pages/demo-profile/DemoProfile.panel";
import { DemoTimelinePanel } from "./pages/demo-timeline/DemoTimeline.panel";
import { DemoBadgePanel } from "./reactstrap/demo-badge/DemoBadge.panel";
import { DemoImagePanel } from "./reactstrap/demo-image/DemoImage.panel";
import { DemoToastPanel } from "./reactstrap/demo-toast/DemoToast.panel";
import { DemoTypographyPanel } from "./reactstrap/demo-typography/DemoTypography.panel";

import {
  DEMO_FORMS_WIDGETS,
  DEMO_FORMS_ALERTS,
  DEMO_FORMS_MODAL,
  DEMO_LAYOUTS_GRID,
  DEMO_LAYOUTS_CARD,
  DEMO_LAYOUTS_ACCORDION,
  DEMO_LAYOUTS_OFFCANVAS,
  DEMO_PAGES_TIMELINE,
  DEMO_RS_TYPOGRAPHY,
  DEMO_RS_BADGES,
  DEMO_RS_TOAST,
  DEMO_RS_IMAGES,
  DEMO_PAGES_COMPARE,
  DEMO_PAGES_PROFILE,
  DEMO_ICONS_NUCLEO,
  DEMO_ICONS_REACT,
} from "./";

export const DemoMainPanel = (): JSX.Element => {
  const [activeTab, setActiveTab] = useState<string>(DEMO_FORMS_WIDGETS);
  const [activeLayoutMenu, setActiveLayoutMenu] = useState<boolean>(false);
  const [activeFormMenu, setActiveFormMenu] = useState<boolean>(false);
  const [activeReactstrapMenu, setActiveReactstrapMenu] = useState<boolean>(false);
  const [activePageMenu, setActivePageMenu] = useState<boolean>(false);
  const [activeIconMenu, setActiveIconMenu] = useState<boolean>(false);

  return (
    <>
      <BoxHeader />
      <Container className="mt--6" fluid>
        <Row>
          <div className="col">
            <Card>
              <CardHeader>
                <h3 className="mb-0">Demo Template Components</h3>
              </CardHeader>
              <CardBody>
                <Row>
                  <Col lg="1">&nbsp;</Col>
                  <Col lg="11" className="d-flex flex-column justify-content-end">
                    <FormGroup>
                      <Dropdown
                        isOpen={activeLayoutMenu}
                        toggle={() => setActiveLayoutMenu(!activeLayoutMenu)}
                      >
                        <DropdownToggle
                          caret
                          color="primary"
                          className="shadow-none text-white border-0"
                        >
                          Layout Menu
                        </DropdownToggle>
                        <DropdownMenu>
                          <DropdownItem
                            className={`font-weight-bold ${
                              activeTab == DEMO_LAYOUTS_GRID ? "bg-lighter" : ""
                            }`}
                            onClick={() => setActiveTab(DEMO_LAYOUTS_GRID)}
                          >
                            Grid Layout
                          </DropdownItem>
                          <DropdownItem
                            className={`font-weight-bold ${
                              activeTab == DEMO_LAYOUTS_CARD ? "bg-lighter" : ""
                            }`}
                            onClick={() => setActiveTab(DEMO_LAYOUTS_CARD)}
                          >
                            Card Layout
                          </DropdownItem>
                          <DropdownItem
                            className={`font-weight-bold ${
                              activeTab == DEMO_LAYOUTS_ACCORDION ? "bg-lighter" : ""
                            }`}
                            onClick={() => setActiveTab(DEMO_LAYOUTS_ACCORDION)}
                          >
                            Accordion
                          </DropdownItem>
                          <DropdownItem
                            className={`font-weight-bold ${
                              activeTab == DEMO_LAYOUTS_OFFCANVAS ? "bg-lighter" : ""
                            }`}
                            onClick={() => setActiveTab(DEMO_LAYOUTS_OFFCANVAS)}
                          >
                            Offcanvas
                          </DropdownItem>
                        </DropdownMenu>
                      </Dropdown>

                      <Dropdown
                        isOpen={activeFormMenu}
                        toggle={() => setActiveFormMenu(!activeFormMenu)}
                      >
                        <DropdownToggle
                          caret
                          color="primary"
                          className="shadow-none text-white border-0"
                        >
                          Forms Menu
                        </DropdownToggle>
                        <DropdownMenu>
                          <DropdownItem
                            className={`font-weight-bold ${
                              activeTab == DEMO_FORMS_WIDGETS ? "bg-lighter" : ""
                            }`}
                            onClick={() => setActiveTab(DEMO_FORMS_WIDGETS)}
                          >
                            Widgets
                          </DropdownItem>
                          <DropdownItem
                            className={`font-weight-bold ${
                              activeTab == DEMO_FORMS_ALERTS ? "bg-lighter" : ""
                            }`}
                            onClick={() => setActiveTab(DEMO_FORMS_ALERTS)}
                          >
                            Alerts
                          </DropdownItem>
                          <DropdownItem
                            className={`font-weight-bold ${
                              activeTab == DEMO_FORMS_MODAL ? "bg-lighter" : ""
                            }`}
                            onClick={() => setActiveTab(DEMO_FORMS_MODAL)}
                          >
                            Modal Windows
                          </DropdownItem>
                        </DropdownMenu>
                      </Dropdown>

                      <Dropdown
                        isOpen={activeReactstrapMenu}
                        toggle={() => setActiveReactstrapMenu(!activeReactstrapMenu)}
                      >
                        <DropdownToggle
                          caret
                          color="primary"
                          className="shadow-none text-white border-0"
                        >
                          Reactstrap Menu
                        </DropdownToggle>
                        <DropdownMenu>
                          <DropdownItem
                            className={`font-weight-bold ${
                              activeTab == DEMO_RS_TYPOGRAPHY ? "bg-lighter" : ""
                            }`}
                            onClick={() => setActiveTab(DEMO_RS_TYPOGRAPHY)}
                          >
                            Typography
                          </DropdownItem>

                          <DropdownItem
                            className={`font-weight-bold ${
                              activeTab == DEMO_RS_BADGES ? "bg-lighter" : ""
                            }`}
                            onClick={() => setActiveTab(DEMO_RS_BADGES)}
                          >
                            Badges
                          </DropdownItem>

                          <DropdownItem
                            className={`font-weight-bold ${
                              activeTab == DEMO_RS_IMAGES ? "bg-lighter" : ""
                            }`}
                            onClick={() => setActiveTab(DEMO_RS_IMAGES)}
                          >
                            Images
                          </DropdownItem>

                          <DropdownItem
                            className={`font-weight-bold ${
                              activeTab == DEMO_RS_TOAST ? "bg-lighter" : ""
                            }`}
                            onClick={() => setActiveTab(DEMO_RS_TOAST)}
                          >
                            Toast
                          </DropdownItem>
                        </DropdownMenu>
                      </Dropdown>

                      <Dropdown
                        isOpen={activePageMenu}
                        toggle={() => setActivePageMenu(!activePageMenu)}
                      >
                        <DropdownToggle
                          caret
                          color="primary"
                          className="shadow-none text-white border-0"
                        >
                          Pages Menu
                        </DropdownToggle>
                        <DropdownMenu>
                          <DropdownItem
                            className={`font-weight-bold ${
                              activeTab == DEMO_PAGES_TIMELINE ? "bg-lighter" : ""
                            }`}
                            onClick={() => setActiveTab(DEMO_PAGES_TIMELINE)}
                          >
                            Timeline
                          </DropdownItem>
                          <DropdownItem
                            className={`font-weight-bold ${
                              activeTab == DEMO_PAGES_PROFILE ? "bg-lighter" : ""
                            }`}
                            onClick={() => setActiveTab(DEMO_PAGES_PROFILE)}
                          >
                            Profile
                          </DropdownItem>

                          <DropdownItem
                            className={`font-weight-bold ${
                              activeTab == DEMO_PAGES_COMPARE ? "bg-lighter" : ""
                            }`}
                            onClick={() => setActiveTab(DEMO_PAGES_COMPARE)}
                          >
                            Product Compare
                          </DropdownItem>
                        </DropdownMenu>
                      </Dropdown>

                      <Dropdown
                        isOpen={activeIconMenu}
                        toggle={() => setActiveIconMenu(!activeIconMenu)}
                      >
                        <DropdownToggle
                          caret
                          color="primary"
                          className="shadow-none text-white border-0"
                        >
                          Icons
                        </DropdownToggle>
                        <DropdownMenu>
                          <DropdownItem
                            className={`font-weight-bold ${
                              activeTab == DEMO_ICONS_REACT ? "bg-lighter" : ""
                            }`}
                            onClick={() => setActiveTab(DEMO_ICONS_REACT)}
                          >
                            React Icons
                          </DropdownItem>
                          <DropdownItem
                            className={`font-weight-bold ${
                              activeTab == DEMO_ICONS_NUCLEO ? "bg-lighter" : ""
                            }`}
                            onClick={() => setActiveTab(DEMO_ICONS_NUCLEO)}
                          >
                            Nucleo Icons
                          </DropdownItem>
                        </DropdownMenu>
                      </Dropdown>
                    </FormGroup>
                  </Col>
                </Row>
              </CardBody>

              <TabContent activeTab={activeTab}>
                <TabPane tabId={DEMO_FORMS_WIDGETS}>
                  <DemoFormsPanel />
                </TabPane>
                <TabPane tabId={DEMO_FORMS_ALERTS}>
                  <DemoAlertsPanel />
                </TabPane>
                <TabPane tabId={DEMO_FORMS_MODAL}>
                  <DemoModalPanel />
                </TabPane>

                <TabPane tabId={DEMO_LAYOUTS_CARD}>
                  <DemoCardsPanel />
                </TabPane>
                <TabPane tabId={DEMO_LAYOUTS_GRID}>
                  <DemoLayoutsPanel />
                </TabPane>
                <TabPane tabId={DEMO_LAYOUTS_ACCORDION}>
                  <DemoAccordionPanel />
                </TabPane>
                <TabPane tabId={DEMO_LAYOUTS_OFFCANVAS}>
                  <DemoOffcanvasPanel />
                </TabPane>

                <TabPane tabId={DEMO_RS_TYPOGRAPHY}>
                  <DemoTypographyPanel />
                </TabPane>
                <TabPane tabId={DEMO_RS_BADGES}>
                  <DemoBadgePanel />
                </TabPane>
                <TabPane tabId={DEMO_RS_IMAGES}>
                  <DemoImagePanel />
                </TabPane>
                <TabPane tabId={DEMO_RS_TOAST}>
                  <DemoToastPanel />
                </TabPane>

                <TabPane tabId={DEMO_PAGES_TIMELINE}>
                  <DemoTimelinePanel />
                </TabPane>
                <TabPane tabId={DEMO_PAGES_PROFILE}>
                  <DemoProfilePanel />
                </TabPane>
                <TabPane tabId={DEMO_PAGES_COMPARE}>
                  <DemoComparePanel />
                </TabPane>

                <TabPane tabId={DEMO_ICONS_NUCLEO}>
                  <DemoNucleoIconsPanel />
                </TabPane>
                <TabPane tabId={DEMO_ICONS_REACT}>
                  <DemoReactIconsPanel />
                </TabPane>
              </TabContent>
            </Card>
          </div>
        </Row>
      </Container>
    </>
  );
};
