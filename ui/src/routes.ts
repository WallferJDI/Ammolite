import { IRoute } from "./types/ui/router";
import { companyMenu } from "./views/pages/company";
import { demoMenu } from "./views/pages/examples";
import { homeMenu } from "./views/pages/home";
import { locationMenu } from "./views/pages/location";

export const routes: IRoute[] = [...homeMenu, ...companyMenu, ...locationMenu, ...demoMenu];

export const LOGIN_ROUTE = "/login";
export const LOGOUT_ROUTE = "/logout";
export const HOME_ROUTE = "/home";
