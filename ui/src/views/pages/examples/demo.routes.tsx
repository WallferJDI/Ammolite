import { ImLab } from "react-icons/im";

import { IRoute } from "@/types/ui/router";

import { AUTHENTICATED } from "@/common/consts";

import { DEMO_ROUTE } from "./demo.routes.const";
import { DemoMainPanel } from "./DemoMain.main";

export const demoMenu: IRoute[] = [
  {
    collapse: false,
    global: false,
    icon: <ImLab size={20} color="#003369" className="mr-2" />,
    path: `${DEMO_ROUTE}`,
    component: <DemoMainPanel />,
    layout: "/admin",
    name: "Examples",
    key: `Home${DEMO_ROUTE}`,
    requiresPermission: AUTHENTICATED,
  },
];
