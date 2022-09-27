// eslint-disable-next-line @typescript-eslint/no-empty-interface
export interface Domain {}

export interface Category extends Domain {
  id: number;
  name: string;
}
