import { ReactNode } from "react";

import { LayoutType } from "@/common/theme";

export interface RouteParams {
  id: string;
}

export interface IRoute {
  collapse?: boolean;
  name?: string;
  icon?: ReactNode;
  state?: string;
  views?: IRoute[];
  miniName?: string;
  global?: boolean;
  path: string;
  component?: JSX.Element;
  layout?: LayoutType;
  redirect?: string;
  key: string;
  requiresPermission: string;
}
