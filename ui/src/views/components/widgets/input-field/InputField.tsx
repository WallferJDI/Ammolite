import { FormGroup, Input, InputProps } from "reactstrap";

type Props = InputProps & {
  id: string;
  label: string;
};

export const InputField = ({ id, label, ...props }: Props) => {
  return (
    <FormGroup>
      <label className="form-control-label" htmlFor={id}>
        {label}
      </label>
      <Input {...props} placeholder={label} />
    </FormGroup>
  );
};
