/*!

=========================================================
* Argon Dashboard PRO React - v1.2.0
=========================================================

* Product Page: https://www.creative-tim.com/product/argon-dashboard-pro-react
* Copyright 2021 Creative Tim (https://www.creative-tim.com)

* Coded by Creative Tim

=========================================================

* The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

*/
import { NavItem, NavLink, Nav, Container, Row, Col } from "reactstrap";

import { logoUrl } from "@/common/theme";

export const AdminFooter = () => {
  return (
    <>
      <Container fluid>
        <footer className="footer pt-0">
          <Row className="justify-content-lg-between">
            <Col lg="12">&nbsp;</Col>
          </Row>
          <Row className="justify-content-lg-between">
            <Col lg="12">
              <div style={{ verticalAlign: "text-bottom", marginBottom: "1px" }}>
                <Nav className="nav-footer ">
                  <NavItem>
                    <NavLink>
                      <img style={{ width: "26px", height: "26px" }} src={logoUrl} alt="logo" />
                    </NavLink>
                  </NavItem>
                  <NavItem>
                    <NavLink href="#dgfhjrds" target="_blank">
                      © {new Date().getFullYear()} Kuehne+Nagel Information Technology School
                    </NavLink>
                  </NavItem>
                  <NavItem>
                    <NavLink
                      href="https://connections.mykn.community/communities/service/html/communityoverview?communityUuid=532a8dba-df92-4366-be9a-2a802dcd87d4"
                      target="_blank"
                    >
                      {" "}
                      KNITS@MyKn {"   "}
                    </NavLink>
                  </NavItem>

                  <NavItem>
                    <NavLink href="mailto:kn.it.school@kuehne-nagel.com" target="_blank">
                      {"   "} Contact Us
                    </NavLink>
                  </NavItem>
                </Nav>
              </div>
            </Col>
          </Row>
        </footer>
      </Container>
    </>
  );
};
