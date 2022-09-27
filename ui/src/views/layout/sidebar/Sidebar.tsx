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
import classNames from "classnames";
import { useState } from "react";
import SimpleBar from "simplebar-react";

import { Navbar } from "reactstrap";

import {
  onMouseEnterSidebar,
  onMouseLeaveSidebar,
  SidebarContent,
  SidebarProps,
  CollapseType,
} from ".";

export const Sidebar = ({ logo, rtlActive = false, routes, userPermissions }: SidebarProps) => {
  const [collapseState, setCollapseState] = useState<CollapseType>({});

  return (
    <Navbar
      className={classNames(
        "sidenav navbar-vertical navbar-expand-xs navbar-light bg-white",
        rtlActive ? "" : "fixed-left"
      )}
      onMouseEnter={onMouseEnterSidebar}
      onMouseLeave={onMouseLeaveSidebar}
    >
      <SimpleBar style={{ maxHeight: "95vh" }}>
        <SidebarContent
          logo={logo}
          collapseState={collapseState}
          setCollapseState={setCollapseState}
          routes={routes}
          userPermissions={userPermissions}
        />
      </SimpleBar>
    </Navbar>
  );
};
