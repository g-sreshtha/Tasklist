import React from "react";
import { useState } from "react";
import { postTask } from "../../Requests/_postTask";
import "./AddTaskPage.css";
import { getAllTasks } from "../../Requests/_getAllTasks";
import { StatusDropdown } from "../StatusDropdown";

interface Props {
  setTasks: React.Dispatch<React.SetStateAction<any>>;
  addTaskPage: boolean;
  setAddTaskPage: React.Dispatch<React.SetStateAction<boolean>>;
  labels: string[];
}

// the props that could be passed is the parts of the use state, so the boolean of add task which gets triggered with you click the button
export const AddTaskPage: React.FC<Props> = ({
  setTasks,
  addTaskPage,
  setAddTaskPage,
  labels,
}) => {
  const [name, setName] = useState<string>("");
  const [deadline, setDeadline] = useState<any>();
  const [status, setStatus] = useState<string>("");

  const handleSubmit = () => {
    postTask({ name, deadline, status })
      .catch((error) => console.error("error adding task", error))
      .then((i) => {
        setAddTaskPage(false);
        getAllTasks()
          .then(setTasks)
          .catch((error) => console.error("error fetching tasks:", error));
      });

    handleCancel();
  };

  const handleCancel = () => {
    setName(() => "");
    setDeadline(() => 0);
    setStatus(() => "");
    setAddTaskPage((prev) => !prev);
  };

  return addTaskPage ? (
    <>
      <div className="overlay"></div>
      <div id="dialogbox-container">
        <h2>Create a new task</h2>
        <div className="rows">
          <h3>Task name</h3>
          <input
            type="text"
            placeholder=" insert name..."
            className="namebox"
            onChange={(e) => setName(() => e.target.value)}
          />
          <h3>Choose a deadline</h3>
          <input
            type="date"
            className="datebox"
            onChange={(e) => setDeadline(() => e.target.value)}
          />
          <label>
            <h3>Choose a status</h3>
          </label>
          <select
            id="status"
            name="status"
            value={status}
            onChange={(e) => setStatus(() => e.target.value)}
            className="dropdown"
          >
            <option value="Not Started">--Please choose an option--</option>
            <option value="Not Started">Not started</option>
            <option value="In Progress">In Progress</option>
            <option value="Completed">Completed</option>
          </select>
        </div>
        <div className="change-buttons">
          <button className="cancel" onClick={handleCancel}>
            Cancel
          </button>
          <button className="save" onClick={handleSubmit}>
            Save
          </button>
        </div>
      </div>
    </>
  ) : null;
};
