const months: string[] = ["01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"];

export const formatJsDate_DD_MM_YYYY = (date: Date) => {
  const dayWithPadding = date.getDate() < 10 ? `0${date.getDate()}` : `${date.getDate()}`;
  return `${dayWithPadding}/${months[date.getMonth()]}/${date.getFullYear()}`;
};

export const parseIntoJsDate_DD_MM_YYYY = (dateAsString: string) => {
  const dataTokens: string[] = dateAsString.split("/");
  return new Date(`${dataTokens[2]}/${dataTokens[1]}/${dataTokens[0]}`);
};

export const dateInBetween = (
  startDateAsString: Date,
  endDateAsString: Date,
  dateToCheckAsString: Date
) => {
  const startDateAsLong = startDateAsString.getTime();
  const endDateAsLong = endDateAsString.getTime();
  const dateToCheckAsLong = dateToCheckAsString.getTime();
  return dateToCheckAsLong > startDateAsLong && dateToCheckAsLong < endDateAsLong;
};

export const evaluateField = (value: string | Date) => {
  if (typeof value === "string") {
    return parseIntoJsDate_DD_MM_YYYY(value);
  }
  if (value instanceof Date) {
    return value;
  }

  return null;
};

export const toFileArray = (filelist: FileList | null): File[] => {
  if (!filelist || filelist.length === 0) {
    return [];
  }
  const files: File[] = [];
  for (let i = 0; i < filelist.length; i++) {
    const fileOrNull = filelist.item(i);
    if (fileOrNull) {
      files.push(fileOrNull);
    }
  }
  return files;
};
