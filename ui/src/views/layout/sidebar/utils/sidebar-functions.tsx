import { IRoute } from "@/types/ui/router";

import { LocationState } from "..";

/**
 * makes the sidenav normal on hover (actually when mouse enters on it)
 */
export const onMouseEnterSidebar = () => {
  if (!document.body.classList.contains("g-sidenav-pinned")) {
    document.body.classList.add("g-sidenav-show");
  }
};

/**
 * makes the sidenav mini on hover (actually when mouse leaves from it)
 */
export const onMouseLeaveSidebar = () => {
  if (!document.body.classList.contains("g-sidenav-pinned")) {
    document.body.classList.remove("g-sidenav-show");
  }
};

/**
 * verifies if routeName is the one active (in browser input)
 */
export const activeRoute = (routeName: string, location: LocationState) => {
  return location.pathname.indexOf(routeName) > -1 ? "active" : "";
};

/**
 * this creates the initial state of this component
 * based on the collapse routes that it gets through routes
 */
export const getViewCollapseInitialState = (routes: IRoute[], location: LocationState) => {
  for (let i = 0; i < routes.length; i++) {
    const routePath = routes[i].path;
    if (routePath) {
      if (location.pathname.indexOf(routePath) !== -1) {
        return true;
      }
    }
  }
  return false;
};
