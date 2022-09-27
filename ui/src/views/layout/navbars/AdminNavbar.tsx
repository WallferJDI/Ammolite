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

import classnames from "classnames";
import { BiUser, HiOutlineLogout } from "react-icons/all";
import { useNavigate } from "react-router-dom";

import {
  Collapse,
  Container,
  DropdownItem,
  DropdownMenu,
  DropdownToggle,
  Media,
  Nav,
  Navbar,
  UncontrolledDropdown,
} from "reactstrap";

// import { useAppDispatch, useAppSelector } from "@/redux/app";
// import { logoutTest, selectLoggedUser } from "@/redux/features";

import { PrincipalUi } from "@/types/ui/principal-ui";

import { Theme } from "@/common/theme";

import { SidebarToggler } from "../sidebar";

interface Props {
  theme: Theme;
  user: PrincipalUi;
}

export const AdminNavbar = ({ theme, user }: Props) => {
  // const dispatch = useAppDispatch();
  // const user = useAppSelector(selectLoggedUser);

  //@TODO this should be replaced by state management solution

  const navigate = useNavigate();

  const logOut = () => {
    // dispatch(logout());
    // dispatch(logoutTest());
    navigate("/auth/login");
  };

  return (
    <>
      <Navbar
        className={classnames(
          "navbar-top navbar-expand border-bottom",
          { "navbar-dark bg-primary": theme === "dark" },
          { "navbar-light bg-secondary": theme === "light" }
        )}
      >
        <Container fluid>
          <div className="d-md-none">
            <SidebarToggler />
          </div>
          <Collapse navbar isOpen={true}>
            <Nav className="align-items-center ml-md-auto" navbar></Nav>
            <Nav className="align-items-center ml-auto ml-md-0" navbar>
              <UncontrolledDropdown nav>
                <DropdownToggle className="nav-link pr-0" color="" tag="a">
                  <Media className="align-items-center">
                    <span className="avatar avatar-sm" style={{ backgroundColor: "transparent" }}>
                      {user?.avatar ? (
                        <img alt="avatar" src={`/avatars/${user?.avatar}`} />
                      ) : (
                        <img alt="avatar" src={`/avatars/avatar.svg`} />
                      )}
                    </span>
                    <Media className="ml-2 d-none d-lg-block">
                      <span className="mb-0 text-sm font-weight-bold">{user?.fullName}</span>
                    </Media>
                  </Media>
                </DropdownToggle>
                <DropdownMenu>
                  <DropdownItem className="noti-title" header tag="div">
                    <h5 className="text-overflow m-0">Welcome!</h5>
                  </DropdownItem>
                  <DropdownItem
                    className="d-flex align-items-center"
                    onClick={() => navigate("/admin/profile")}
                  >
                    <BiUser color="primary" size={25} />
                    <span className="font-weight-600">My profile</span>
                  </DropdownItem>

                  <DropdownItem divider />
                  <DropdownItem className="d-flex align-items-center" onClick={logOut}>
                    <HiOutlineLogout color="primary" size={25} />
                    <span className="font-weight-600">Logout</span>
                  </DropdownItem>
                </DropdownMenu>
              </UncontrolledDropdown>
            </Nav>
          </Collapse>
        </Container>
      </Navbar>
    </>
  );
};
