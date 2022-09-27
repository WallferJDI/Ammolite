export type LayoutType = "/admin" | "/auth" | "/rtl";
export type Theme = "light" | "dark";

export const currentTheme: Theme = "light";
export const rtlActive = false;
export const logoUrl = "/general/brand/logo.png";

export const ThemeColors = {
  gray: {
    50: "#F7FAFC",
    100: "#EDF2F7",
    200: "#E2E8F0",
    300: "#CBD5E0",
    400: "#A0AEC0",
    500: "#718096",
    600: "#4A5568",
    700: "#2D3748",
    800: "#1A202C",
    900: "#171923",
  },
  theme: {
    default: "#172b4d",
    primary: "#003369",
    secondary: "#f4f5f7",
    info: "#0099DA",
    success: "#08C792",
    danger: "#ED2939",
    warning: "#fb6340",
    blue: "#003369",
    indigo: "#5603ad",
    purple: "#8965e0",
    pink: "#f3a4b5",
    red: "#ED2939",
    orange: "#fb6340",
    yellow: "#ffd600",
    green: "#08C792",
    teal: "#0099DA",
    cyan: "#2bffc6",
    neutral1: "#F6F5F0",
    neutral2: "#C5C6BF",
    neutral3: "#929288",
    neutral4: "#62635B",
    neutral5: "#373832",
  },
  black: "#12263F",
  white: "#FFFFFF",
  transparent: "transparent",
};

export const mode: Theme = "light";
export const fonts = {
  base: "Rubik",
};
