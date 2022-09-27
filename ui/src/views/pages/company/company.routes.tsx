import { VscOrganization } from "react-icons/vsc";

import { IRoute } from "@/types/ui/router";

import { AUTHENTICATED } from "@/common/consts";

import { CompanyPage } from "./Company.main";
import { COMPANY_ROUTE } from "./company.routes.const";

export const companyMenu: IRoute[] = [
  {
    collapse: false,
    global: false,
    icon: <VscOrganization size={20} color="#003369" className="mr-2" />,
    path: `${COMPANY_ROUTE}`,
    component: <CompanyPage />,
    layout: "/admin",
    name: "Company",
    key: `Home${COMPANY_ROUTE}`,
    requiresPermission: AUTHENTICATED,
  },
];
