import { Route } from "react-router-dom";

import { IRoute } from "@/types/ui/router";

import { LayoutType } from "@/common/theme";

const getLayout = (route: IRoute, layout: LayoutType, userPermissions: string[]) => {
  if (
    route.layout === layout &&
    userPermissions.includes(route.requiresPermission) &&
    route.component
  ) {
    return <Route path={route.layout + route.path} element={route.component} key={route.key} />;
  } else {
    return null;
  }
};

const getRouteViews = (routes: IRoute[], layout: LayoutType, userPermissions: string[]) => {
  return routes.map(route => getLayout(route, layout, userPermissions));
};

export const getRoutes = (routes: IRoute[], layout: LayoutType, userPermissions: string[]) => {
  return routes.map(route => {
    if (
      route.collapse &&
      route.views &&
      route.views.length > 0 &&
      userPermissions.includes(route.requiresPermission)
    ) {
      return getRouteViews(route.views, layout, userPermissions);
    }

    return getLayout(route, layout, userPermissions);
  });
};
