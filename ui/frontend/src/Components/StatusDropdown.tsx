import React from "react";
import { useState } from "react";
import "./StatusDropdown.css";
import { AddTaskPage } from "./addTaskPage/AddTaskPage";
import { GiPlainCircle } from "react-icons/gi";
// i will need to pass some props down, i think itll be setchangedstatus, changed status
interface Props {
  changedStatus: string;
  setChangedStatus: React.Dispatch<React.SetStateAction<string>>;
  status: string;
  labels: string[];
}
export const StatusDropdown: React.FC<Props> = ({
  changedStatus,
  setChangedStatus,
  status,
  labels,
}) => {
  const [open, setOpen] = useState<boolean>(false);
  const handleOpen = () => {
    setOpen((prev) => !prev);
  };

  const handleSelected = (label: string) => {
    setChangedStatus(label);
    setOpen(false);
  };
  return (
    <div className="dropdown-container">
      <div
        className={`dropbtn label-${status.toLowerCase().replace(/\s/g, "-")}`}
        onClick={handleOpen}
      >
        {/* <GiPlainCircle style={{ paddingRight: "6px", fontSize: "10px" }} /> */}
        {status ? changedStatus : "please choose an option"}
      </div>
      {open && (
        <div className="dropdown-content">
          {labels.map((label) => (
            <>
              <div
                key={label}
                onClick={() => handleSelected(label)}
                className={`label-${label.toLowerCase().replace(/\s/g, "-")}`}
              >
                {label}
              </div>
            </>
          ))}
        </div>
      )}
    </div>
  );
};
