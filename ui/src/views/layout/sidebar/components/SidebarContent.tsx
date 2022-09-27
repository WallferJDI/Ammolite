import { Link } from "react-router-dom";

import { Collapse, Nav } from "reactstrap";

import { IRoute } from "@/types/ui/router";

import { ISidebarLogo } from "..";

import { SidebarPanel, CollapseType } from ".";

interface Props {
  logo: ISidebarLogo;
  collapseState: CollapseType;
  setCollapseState: React.Dispatch<CollapseType>;
  routes: IRoute[];
  userPermissions: string[];
}

export const SidebarContent = ({
  logo,
  collapseState,
  setCollapseState,
  routes,
  userPermissions,
}: Props) => {
  return (
    <>
      <div className="scrollbar-inner">
        <div className="mb-2" style={{ height: "220px" }}>
          {logo && (
            <Link to="/">
              <img alt={logo.imgAlt} className="h-100" src={logo.imgSrc} />
            </Link>
          )}
        </div>

        <div className="navbar-inner">
          <Collapse navbar isOpen={true}>
            <hr className="my-3" />
            <Nav navbar>
              <SidebarPanel
                routes={routes}
                userPermissions={userPermissions}
                collapseState={collapseState}
                setCollapseState={setCollapseState}
              />
            </Nav>
            <hr className="my-3" />

            <h6 className="navbar-heading p-0 text-muted">
              <span className="docs-normal">Support</span>
              <span className="docs-mini">S</span>
            </h6>
          </Collapse>
        </div>
      </div>
    </>
  );
};
