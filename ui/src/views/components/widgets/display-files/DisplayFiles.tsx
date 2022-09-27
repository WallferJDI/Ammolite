interface Props {
  files: File[];
}

export const DisplayFiles = ({ files }: Props) => {
  return (
    <p className="mb-0">
      {files.length > 0 && `Files: ${files.map(file => file.name).join(", ")}`}
    </p>
  );
};
