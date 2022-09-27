import { MouseEvent } from "react";
import { HiCheck, HiX } from "react-icons/hi";
import { Column } from "react-table";

import { Button } from "reactstrap";

import { ThemeColors } from "@/common/theme";

export interface IDefaultActionButtons {
  onDetailsButtonClick?: (e: MouseEvent<HTMLButtonElement>) => void;
  onRemoveButtonClick?: (e: MouseEvent<HTMLButtonElement>) => void;
}

export const ActionColumnEditDelete = <T extends { id: string | undefined }>({
  onDetailsButtonClick,
  onRemoveButtonClick,
}: IDefaultActionButtons) => {
  return {
    accessor: "action",
    Header: "",
    Cell: ({ row }) => {
      const item = row.original as T;
      if (!item.id) return <></>;

      const id = item.id.toString();
      return (
        <div className="table-action-button-group">
          <Button
            id={id}
            className="btn-icon m-1"
            type="button"
            color="info"
            onClick={onDetailsButtonClick}
            data-testid="detailButton"
          >
            <span id={id} className="btn-inner--icon">
              <i id={id} className="ni ni-badge" />
            </span>
          </Button>

          <Button
            id={id}
            className="btn-icon m-1"
            color="danger"
            type="button"
            onClick={onRemoveButtonClick}
            data-testid="removeButton"
          >
            <span id={id} className="btn-inner--icon">
              <i id={id} className="ni ni-fat-remove" />
            </span>
          </Button>
        </div>
      );
    },
  } as Column;
};

export const DisplayActiveOrInactiveIcon = <T extends { active: boolean }>() => {
  return {
    accessor: "active",
    Header: "Active",
    Cell: ({ row }) => {
      const { active } = row.original as T;
      return (
        <div>
          {active ? (
            <HiCheck color={ThemeColors.theme.success} size={25} />
          ) : (
            <HiX color={ThemeColors.theme.red} size={25} />
          )}
        </div>
      );
    },
  } as Column;
};
