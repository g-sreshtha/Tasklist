import React from "react";
import { AddTaskPage } from "./addTaskPage/AddTaskPage";
import "./NavBar.css";
import { FilterBar } from "./FilterBar";
import { useState } from "react";

interface Props {
  setTasks: React.Dispatch<React.SetStateAction<any>>;
  addTaskPage: boolean;
  setAddTaskPage: React.Dispatch<React.SetStateAction<boolean>>;
  labels: string[];
}

export const NavBar: React.FC<Props> = ({
  setTasks,
  addTaskPage,
  setAddTaskPage,
  labels,
}) => {
  const [open, setOpen] = useState<boolean>(false);
  const toggleAddTaskPage = () => {
    setAddTaskPage((prev) => !prev);
    console.log("clicked");
  };

  const handleOpen = () => {
    setOpen((prev) => !prev);
    console.log("opened!");
  };
  return (
    <>
      <div className="container-navbar">
        <div className="button-div">
          <button onClick={handleOpen}>Sort by</button>
          <button onClick={toggleAddTaskPage}>Add</button>
        </div>
        <div>
          <FilterBar open={open} setOpen={setOpen} />
          <AddTaskPage
            setTasks={setTasks}
            addTaskPage={addTaskPage}
            setAddTaskPage={setAddTaskPage}
            labels={labels}
          />
        </div>
      </div>
    </>
  );
};
