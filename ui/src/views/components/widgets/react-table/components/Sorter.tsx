import { MdArrowDownward, MdArrowUpward } from "react-icons/md";
import { HeaderGroup } from "react-table";

interface Props {
  column: HeaderGroup<Record<string, unknown>>;
}

export const Sorter = ({ column }: Props) => {
  return (
    <span className="react-table-sorting">
      {column.isSorted ? column.isSortedDesc ? <MdArrowDownward /> : <MdArrowUpward /> : <></>}
    </span>
  );
};
