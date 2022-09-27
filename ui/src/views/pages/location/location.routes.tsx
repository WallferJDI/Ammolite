// import { FaUserAlt } from "react-icons/fa";

import { FaMapMarkerAlt } from "react-icons/fa";

import { IRoute } from "@/types/ui/router";

import { AUTHENTICATED } from "@/common/consts";

import { LocationPage, LOCATION_ROUTE } from ".";

export const locationMenu: IRoute[] = [
  {
    collapse: true,
    global: false,
    icon: <FaMapMarkerAlt size={20} color="#003369" className="mr-2" />,
    path: `${LOCATION_ROUTE}`,
    component: <LocationPage />,
    layout: "/admin",
    name: "Location",
    key: `Location${LOCATION_ROUTE}`,
    requiresPermission: AUTHENTICATED,
  },
];
