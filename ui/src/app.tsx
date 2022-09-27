import { Navigate, Route, Routes } from "react-router-dom";
// import { useRegisterSW } from "virtual:pwa-register/react";

// import { useAppSelector } from "@/redux/app";
// import { selectLoggedUser } from "@/redux/features";

// import { LOGIN_ROUTE } from "@/pages/auth";
// import { HOME_ROUTE } from "@/pages/home";

import { mockPrincipal } from "./__mocks/data/principal-mocks";
import { AUTHENTICATED } from "./common/consts";
import { HOME_ROUTE, LOGIN_ROUTE, routes } from "./routes";
import { PrincipalUi } from "./types/ui/principal-ui";
import { AdminLayout, getRoutes } from "./views/layout";
import { AuthLayout } from "./views/layout/AuthLayout";

export const App = () => {
  // const user = useAppSelector(selectLoggedUser);

  //@TODO this should be in a state management library
  const user: PrincipalUi = mockPrincipal("stefano.fiorenza", [AUTHENTICATED]);

  // const intervalMS = 60 * 60 * 1000; // every 6 minutes

  // useRegisterSW({
  //   onRegistered(r) {
  //     r &&
  //       setInterval(() => {
  //         r.update();
  //       }, intervalMS);
  //   },
  // });

  // console.log(user);
  // console.log(routes);

  return (
    <Routes>
      {user !== null && (
        <Route element={<AdminLayout />}>{getRoutes(routes, "/admin", user.permissions)}</Route>
      )}
      {user === null && (
        <Route element={<AuthLayout />}>{getRoutes(routes, "/auth", ["ANONYMOUS"])}</Route>
      )}

      <Route
        path="*"
        element={<Navigate to={user ? `admin${HOME_ROUTE}` : `auth${LOGIN_ROUTE}`} replace />}
      />
    </Routes>
  );
};
