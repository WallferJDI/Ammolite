import classnames from "classnames";
import { NavLink as NavLinkRRD } from "react-router-dom";

import { Collapse, Nav, NavItem, NavLink } from "reactstrap";

import { IRoute } from "@/types/ui/router";

import { getViewCollapseInitialState, activeRoute } from "..";

import { RouteLinkLabel } from ".";

export type CollapseType = {
  [key: string]: boolean;
};

interface Props {
  routes: IRoute[];
  userPermissions: string[];
  collapseState: CollapseType;
  setCollapseState: React.Dispatch<CollapseType>;
}

export const SidebarPanel = ({
  routes,
  userPermissions,
  collapseState,
  setCollapseState,
}: Props) => {
  return (
    <>
      {routes
        // only take in routes that aren't global
        .filter(route => !route.global && userPermissions.includes(route.requiresPermission))
        .map(route => {
          // route menus
          if (route.collapse && route.state && route.views) {
            const st: CollapseType = {};

            st[route["state"]] = !collapseState[route.state];

            return (
              <NavItem key={route.key}>
                <NavLink
                  data-toggle="collapse"
                  aria-expanded={collapseState[route.state]}
                  className={classnames({
                    active: getViewCollapseInitialState(route.views, location),
                  })}
                  onClick={e => {
                    e.preventDefault();
                    setCollapseState({ ...collapseState, ...st });
                  }}
                >
                  <RouteLinkLabel route={route} />
                </NavLink>

                <Collapse isOpen={collapseState[route.state]}>
                  <Nav className="nav-sm flex-column">
                    <SidebarPanel
                      routes={route.views}
                      userPermissions={userPermissions}
                      collapseState={collapseState}
                      setCollapseState={setCollapseState}
                    />
                  </Nav>
                </Collapse>
              </NavItem>
            );
            // route menu children
          } else {
            return (
              <NavItem className={activeRoute(route.layout + route.path, location)} key={route.key}>
                <NavLink
                  to={route.layout + route.path}
                  // onClick={() => closeSidebar(dispatch)}
                  tag={NavLinkRRD}
                >
                  <RouteLinkLabel route={route} />
                </NavLink>
              </NavItem>
            );
          }
        })}
    </>
  );
};
