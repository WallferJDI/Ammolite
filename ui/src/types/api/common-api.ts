export interface ICreate<T> {
  body: T;
}

export interface IUpdated<T> {
  id: number;
  body: T;
}

export interface IPartiallyUpdated<T> {
  id: number;
  body: Partial<T>;
}
