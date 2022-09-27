import classnames from "classnames";
import { HiMenu } from "react-icons/hi";

/*
import { useAppDispatch, useAppSelector } from "@/redux/app";
import { toggleSidebar } from "@/redux/features";
*/

export const SidebarToggler = () => {
  // const { isSidebarOpen } = useAppSelector(state => state.sidebar);
  // const dispatch = useAppDispatch();
  const isSidebarOpen = true;
  return (
    <div className="ml-auto sidebar-toggler">
      <div
        className={classnames("sidenav-toggler", {
          active: isSidebarOpen,
        })}
        role="button"
        tabIndex={0}
        // @docs https://github.com/jsx-eslint/eslint-plugin-jsx-a11y/blob/main/docs/rules/click-events-have-key-events.md
        // onKeyDown={() =>  dispatch(toggleSidebar())}
        // onClick={() => dispatch(toggleSidebar())}
      >
        <HiMenu size={25} color="#003369" />
      </div>
    </div>
  );
};
