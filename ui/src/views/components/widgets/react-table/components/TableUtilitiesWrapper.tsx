import { cloneElement } from "react";
import { Row } from "react-table";

interface Props {
  selectedFlatRows: Row<Record<string, unknown>>[];
  toggleAllRowsSelected: (value?: boolean | undefined) => void;
  children: JSX.Element;
}

export const TableUtilitiesWrapper = <T,>({
  children,
  selectedFlatRows,
  toggleAllRowsSelected,
}: Props) => {
  const selectedEntities = selectedFlatRows.map(row => row.original as unknown as T);
  return (
    <>{cloneElement(children, { selectedFlatRows: selectedEntities, toggleAllRowsSelected })}</>
  );
};
