import { ReactNode } from "react";

import { NavItem, NavLink } from "reactstrap";

interface SidebarLinkProps {
  children: string;
  icon: ReactNode;
  href: string;
}

export const SidebarLink = ({ icon, children, href }: SidebarLinkProps) => {
  return (
    <NavItem>
      <NavLink href={href} target="_blank">
        <div style={{ minWidth: "2rem" }}>{icon}</div>
        <span className="nav-link-text">{children}</span>
      </NavLink>
    </NavItem>
  );
};
