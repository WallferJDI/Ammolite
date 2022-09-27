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
import { useRef } from "react";
import { Outlet } from "react-router-dom";

import { routes } from "@/routes";

import { mockPrincipal } from "@/__mocks/data/principal-mocks";
import { AUTHENTICATED } from "@/common/consts";
import { currentTheme, logoUrl, rtlActive } from "@/common/theme";

import { PrincipalUi } from "../../types/ui/principal-ui";

import { AdminFooter } from "./footers";
import { AdminNavbar } from "./navbars";
import { Sidebar } from "./sidebar";

import { useScrollToTop } from ".";

export const AdminLayout = () => {
  //@TODO this should be in a state management library
  const user: PrincipalUi = mockPrincipal("stefano.fiorenza", [AUTHENTICATED]);

  const mainContentRef = useRef(document.createElement("div"));
  useScrollToTop(mainContentRef);

  return (
    <>
      <Sidebar
        logo={{
          innerLink: "/",
          imgSrc: logoUrl,
          imgAlt: "KNITS Logo",
        }}
        userPermissions={user.permissions}
        routes={routes}
        rtlActive={rtlActive}
      />
      <div className="main-content" ref={mainContentRef}>
        <AdminNavbar user={user} theme={currentTheme} />
        <Outlet />
        <AdminFooter />
      </div>
    </>
  );
};
