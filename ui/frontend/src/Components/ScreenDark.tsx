import React from "react";
import "./ScreenDark.css";

interface Props {
  addTaskPage: boolean;
  setAddTaskPage: React.Dispatch<React.SetStateAction<boolean>>;
}
export const ScreenDark: React.FC<Props> = ({
  addTaskPage,
  setAddTaskPage,
}) => {
  return addTaskPage ? <div className="background"></div> : <div></div>;
};
