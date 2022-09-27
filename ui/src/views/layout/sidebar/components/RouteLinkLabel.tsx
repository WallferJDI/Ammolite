import { IRoute } from "@/types/ui/router";

interface Props {
  route: IRoute;
}

export const RouteLinkLabel = ({ route }: Props) => {
  return (
    <>
      {route.icon ? (
        <>
          <div className="d-flex justify-content-center" style={{ minWidth: "3rem" }}>
            {route.icon}
          </div>
          <span className="nav-link-text">{route.name}</span>
        </>
      ) : route.miniName ? (
        <>
          <span className="sidenav-mini-icon">{route.miniName}</span>
          <span className="sidenav-normal"> {route.name} </span>
        </>
      ) : (
        <>
          <span className="sidenav-normal"> {route.name} </span>
        </>
      )}
    </>
  );
};
