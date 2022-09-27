import { IRoute } from "@/types/ui/router";

export interface ISidebarLogo {
  /**
   * @description innerLink is for links that will direct the user within the app
   * it will be rendered as <Link to="...">...</Link> tag
   */
  innerLink?: string;

  /**
   * @description outerLink is for links that will direct the user outside the app
   * it will be rendered as simple <a href="...">...</a> tag
   */
  outerLink?: string;
  /**
   * @description the image src of the logo
   */
  imgSrc: string;
  /**
   * @description the alt for the img
   */
  imgAlt: string;
}

export interface SidebarProps {
  logo: ISidebarLogo;
  /**
   * @default false
   * @description this will make the sidebar to stay on the right side
   */
  rtlActive: boolean;
  routes: IRoute[];
  userPermissions: string[];
}

export type stType = {
  [key: string]: boolean;
};

export interface LocationState {
  pathname: string;
}
