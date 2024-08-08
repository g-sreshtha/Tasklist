import React from "react";

interface Props {
  open: boolean;
  setOpen: React.Dispatch<React.SetStateAction<boolean>>;
}
export const FilterBar: React.FC<Props> = ({ open, setOpen }) => {
  return open ? <div></div> : <div></div>;
};
