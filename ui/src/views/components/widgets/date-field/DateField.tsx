import { Dispatch, SetStateAction } from "react";
import ReactDatePicker from "react-datepicker";

import { FormGroup } from "reactstrap";

import { evaluateField } from "@/common/utils";

type Props = {
  id: string;
  label: string;
  value: Date | undefined;
  setValue: Dispatch<SetStateAction<Date | undefined>>;
  style?: { height: string };
};

export const DateField = ({ id, label, value, setValue, style, ...props }: Props) => {
  const currentValue = value ? evaluateField(value) : null;

  return (
    <FormGroup>
      <label className="form-control-label" htmlFor={id}>
        {label}
      </label>
      <ReactDatePicker
        {...props}
        className={style ? "form-control-height form-control" : "form-control"}
        selected={currentValue}
        onChange={(date: Date) => setValue(date)}
      />
    </FormGroup>
  );
};
