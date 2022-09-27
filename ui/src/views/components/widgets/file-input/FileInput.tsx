import { MdAttachFile } from "react-icons/md";

type Props = React.DetailedHTMLProps<
  React.InputHTMLAttributes<HTMLInputElement>,
  HTMLInputElement
> & {
  id: string;
};

export const FileInput = ({ id, ...props }: Props) => {
  return (
    <>
      <label id="fileUpload" className="attachment-button" htmlFor={id}>
        <MdAttachFile size={17} />
      </label>
      <input id={id} className="hidden" type="file" multiple {...props} />
    </>
  );
};
