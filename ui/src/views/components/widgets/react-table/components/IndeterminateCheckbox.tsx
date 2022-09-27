import { forwardRef, useEffect, useRef } from "react";

interface CheckboxProps {
  indeterminate?: boolean;
}

export const IndeterminateCheckbox = forwardRef(
  // @todo find type for ref
  ({ indeterminate, ...rest }: CheckboxProps, ref: any) => {
    const defaultRef = useRef();
    const resolvedRef = ref || defaultRef;

    useEffect(() => {
      resolvedRef.current.indeterminate = indeterminate;
    }, [resolvedRef, indeterminate]);

    return <input type="checkbox" ref={resolvedRef} {...rest} />;
  }
);

IndeterminateCheckbox.displayName = "IndeterminateCheckbox";
