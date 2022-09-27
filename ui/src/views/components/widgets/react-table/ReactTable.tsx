import { useMemo } from "react";
import {
  Column,
  useGlobalFilter,
  usePagination,
  useRowSelect,
  useSortBy,
  useTable,
} from "react-table";

import {
  TableUtilitiesWrapper,
  IndeterminateCheckbox,
  PaginationReactTable,
  Sorter,
  GlobalFilter,
} from ".";

interface Props<T> {
  data: T[];
  columns: Column[];
  selectElement?: JSX.Element;
}

export const ReactTable = <T,>({ data, columns, selectElement }: Props<T>) => {
  const memoizedData: Array<T> = useMemo(() => data, [data]);
  const memoizedColumns: Array<Column> = useMemo(() => columns, [columns]);

  const {
    getTableProps,
    getTableBodyProps,
    headerGroups,
    prepareRow,
    page,
    rows,
    canPreviousPage,
    canNextPage,
    pageOptions,
    nextPage,
    previousPage,
    setPageSize,
    gotoPage,
    setGlobalFilter,
    selectedFlatRows,
    toggleAllRowsSelected,
    getToggleAllPageRowsSelectedProps,
    state: { pageIndex, pageSize, globalFilter },
  } = useTable(
    {
      columns: memoizedColumns,
      data: memoizedData,
      initialState: {
        hiddenColumns: ["id"],
      },
    },
    useGlobalFilter,
    useSortBy,
    usePagination,
    useRowSelect,
    hooks => {
      if (selectElement) {
        hooks.visibleColumns.push(columns => [
          // Let's make a column for selection
          {
            id: "selection",
            // The header can use the table's getToggleAllRowsSelectedProps method
            // to render a checkbox
            Header: () => {
              return (
                <div>
                  <IndeterminateCheckbox {...getToggleAllPageRowsSelectedProps()} />
                </div>
              );
            },
            // The cell can use the individual row's getToggleRowSelectedProps method
            // to the render a checkbox
            Cell: ({ row }) => {
              return (
                <div>
                  <IndeterminateCheckbox {...row.getToggleRowSelectedProps()} />
                </div>
              );
            },
          },
          ...columns,
        ]);
      }
    }
  );

  return (
    <>
      <div className="react-table-filter d-flex justify-content-between align-items-center">
        <GlobalFilter filter={globalFilter} setFilter={setGlobalFilter} />
        {selectElement && (
          <TableUtilitiesWrapper
            selectedFlatRows={selectedFlatRows}
            toggleAllRowsSelected={() => toggleAllRowsSelected(false)}
          >
            {selectElement}
          </TableUtilitiesWrapper>
        )}
      </div>
      <table {...getTableProps()} className="react-table">
        <thead className="react-table-thead">
          {
            // Loop over the header rows
            headerGroups.map((headerGroup, i) => (
              // Apply the header row props
              <tr {...headerGroup.getHeaderGroupProps()} key={i} className="react-table-tr">
                {
                  // Loop over the headers in each row
                  headerGroup.headers.map((column, i) => {
                    return (
                      // Apply the header cell props
                      <th
                        {...column.getHeaderProps(column.getSortByToggleProps())}
                        key={i}
                        className="react-table-th"
                      >
                        {
                          // Render the header
                          column.render("Header")
                        }
                        <Sorter column={column} />
                      </th>
                    );
                  })
                }
              </tr>
            ))
          }
        </thead>

        {/* Apply the table body props */}
        <tbody {...getTableBodyProps()} className="react-table-tbody">
          {selectElement && (
            <div className="react-table-all-checkbox">
              <IndeterminateCheckbox {...getToggleAllPageRowsSelectedProps()} />
            </div>
          )}
          {
            // Loop over the table rows
            page.map(row => {
              // Prepare the row for display
              prepareRow(row);
              return (
                // Apply the row props
                <tr {...row.getRowProps()} className="react-table-tr">
                  {
                    // Loop over the rows cells
                    row.cells.map(cell => {
                      // Apply the cell props
                      return (
                        <td
                          data-label={cell.column.Header}
                          {...cell.getCellProps()}
                          className="react-table-td"
                        >
                          {
                            // Render the cell contents
                            cell.render("Cell")
                          }
                        </td>
                      );
                    })
                  }
                </tr>
              );
            })
          }
        </tbody>
      </table>
      <PaginationReactTable
        canPreviousPage={canPreviousPage}
        canNextPage={canNextPage}
        pageOptions={pageOptions}
        nextPage={nextPage}
        previousPage={previousPage}
        setPageSize={setPageSize}
        pageIndex={pageIndex}
        pageSize={pageSize}
        gotoPage={gotoPage}
        rows={rows}
      />
    </>
  );
};
