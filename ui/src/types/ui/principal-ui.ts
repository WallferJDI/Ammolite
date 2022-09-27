export interface PrincipalUi {
  id: number;
  memberId: number;
  accountNonExpired: boolean;
  accountNonLocked: boolean;
  /**
   * @default always empty array []
   **/
  permissions: string[];
  /**
   * @default avatar.svg
   **/
  avatar: string;
  countryIso2: string;
  credentialsExpired: boolean;
  credentialsNonExpired: boolean;
  enabled: boolean;
  expired: boolean;
  fullName: string;
  locked: boolean;
  password: string | null;
  token?: string;
  /**
   * username is email
   **/
  username: string;
}
