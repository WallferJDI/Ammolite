import { IRoute } from "@/types/ui/router";

import { AUTHENTICATED } from "@/common/consts";

import { HOME_ROUTE } from "./home.routes.const";
import { HomePage } from "./HomePage";

export const homeMenu: IRoute[] = [
  {
    collapse: false,
    global: true,
    path: `${HOME_ROUTE}`,
    component: <HomePage />,
    layout: "/admin",
    name: `${HOME_ROUTE}`,
    key: `Home${HOME_ROUTE}`,
    requiresPermission: AUTHENTICATED,
  },
];
