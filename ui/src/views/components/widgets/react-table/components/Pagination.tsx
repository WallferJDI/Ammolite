import { FaGreaterThan, FaLessThan } from "react-icons/fa";
import { Row } from "react-table";

interface Props {
  canPreviousPage: boolean;
  canNextPage: boolean;
  pageOptions: number[];
  nextPage: () => void;
  previousPage: () => void;
  setPageSize: (pageSize: number) => void;
  pageIndex: number;
  pageSize: number;
  gotoPage: (updater: number | ((pageIndex: number) => number)) => void;
  rows: Row[];
}

export const PaginationReactTable = ({
  canNextPage,
  canPreviousPage,
  nextPage,
  pageIndex,
  pageOptions,
  pageSize,
  setPageSize,
  previousPage,
  rows,
}: Props) => {
  return (
    <div className="d-flex justify-content-between ml-5 mr-5 mt-4 pb-4">
      <div>
        <div className="d-flex flex-row align-items-center">
          <span className="mr-1">Show</span>
          <div>
            <select
              className="form-control form-control-sm"
              value={pageSize}
              onChange={e => {
                setPageSize(Number(e.target.value));
              }}
            >
              {[10, 25, 50, 100].map(pageSize => (
                <option key={pageSize} value={pageSize}>
                  {pageSize}
                </option>
              ))}
            </select>
          </div>
          <span className="ml-1">entries.</span>
        </div>
        <div className="d-flex align-items-center justify-content-center mt-1">
          <span className="ml-1">Out of {rows.length}</span>
        </div>
      </div>

      <div className="d-flex flex-column align-items-center">
        <div className="d-flex flex-row">
          <button
            className="page-link rounded mr-2"
            onClick={() => previousPage()}
            disabled={!canPreviousPage}
          >
            <FaLessThan />
          </button>

          <button className="page-link rounded" onClick={() => nextPage()} disabled={!canNextPage}>
            <FaGreaterThan />
          </button>
        </div>
        <div>
          <span>
            Page{" "}
            <strong>
              {pageIndex + 1} of {pageOptions.length}
            </strong>
          </span>
        </div>
      </div>
    </div>
  );
};
