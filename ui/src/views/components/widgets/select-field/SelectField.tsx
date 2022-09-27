import Select from "react-select";
import makeAnimated from "react-select/animated";
import { StateManagerProps } from "react-select/dist/declarations/src/useStateManager";

import { FormGroup } from "reactstrap";

import { SelectOption } from "@/types/ui/common-ui";

import { SELECT_ALL } from "@/common/consts";

type Props = StateManagerProps & {
  id: string;
  label: string;
};

export const SelectField = ({ id, label, ...props }: Props) => {
  const options = props.options as Array<SelectOption>;

  const sortedArray = options.sort((a, b) => a.label.localeCompare(b.label));

  sortedArray.splice(sortedArray.indexOf(SELECT_ALL), 1);
  sortedArray.unshift(SELECT_ALL);

  return (
    <FormGroup>
      <label className="form-control-label" htmlFor={id}>
        {label}
      </label>
      <Select {...props} options={sortedArray} components={makeAnimated()} />
    </FormGroup>
  );
};
