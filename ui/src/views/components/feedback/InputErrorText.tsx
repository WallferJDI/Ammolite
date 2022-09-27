interface Props {
  touched: boolean;
  error: string | undefined;
}

export const InputErrorText = ({ touched, error }: Props) => {
  return <>{touched && error && <p className="text-md text-red">{error}</p>}</>;
};
