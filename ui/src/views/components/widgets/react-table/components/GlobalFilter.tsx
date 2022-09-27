import { Input } from "reactstrap";

interface Props {
  filter: string;
  setFilter: (filterValue: string) => void;
}

export const GlobalFilter = ({ filter, setFilter }: Props) => {
  return (
    <Input
      className="react-table-search"
      placeholder="Search"
      value={filter || ""}
      onChange={e => setFilter(e.target.value)}
    />
  );
};
