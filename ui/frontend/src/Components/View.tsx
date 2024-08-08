import React from "react";
import { useState, useEffect } from "react";
import "./View.css";
import { getAllTasks } from "../Requests/_getAllTasks";
import { MdDelete } from "react-icons/md";
import { deleteTask } from "../Requests/_deleteTask";
import { BiSolidRename } from "react-icons/bi";
import { PiSpinnerLight } from "react-icons/pi";
import { BsCalendar2Day } from "react-icons/bs";
import { BiCalendarHeart } from "react-icons/bi";
import { NavBar } from "./NavBar";
import { putTasks } from "../Requests/_putTask";
import { StatusDropdown } from "./StatusDropdown";
import { TiTickOutline } from "react-icons/ti";
import { GiPlainCircle } from "react-icons/gi";

export const View: React.FC = () => {
  interface Tasks {
    id: any;
    name: string;
    status: string;
    created_date: Date;
    deadline: Date;
  }

  const [tasks, setTasks] = useState<Tasks[]>([]);
  const [addTaskPage, setAddTaskPage] = useState<boolean>(false); //maybe use a useeffect to handle on click so when it changes we get the pop up page
  const [editTask, setEditTask] = useState<boolean>(false);
  const [changeName, setChangeName] = useState<string>("");
  const [changedDeadline, setChangedDeadline] = useState<any>();
  const [changedStatus, setChangedStatus] = useState<string>("");
  const labels: string[] = ["Not Started", "In Progress", "Completed"];

  useEffect(() => {
    getAllTasks()
      .then((tasks: Tasks[]) => {
        setTasks(tasks);
        if (tasks.length > 0) {
          setChangedDeadline(tasks[0].deadline);
        }
      })
      .catch((error) => console.error("error fetching tasks:", error));
    console.log("done!");
  }, []);

  const handleDelete = (taskId: string) => {
    const updatedTask = tasks.filter((t) => t.id !== taskId); // this just filters through the id's to find the one that are not the one that youre trying to delete and then only saves those tasks, excluding the one you want to delete.
    deleteTask(taskId)
      .then(() => setTasks(updatedTask))
      .catch((error) => console.error("cannot delete task", error));
    console.log("deleted!");
  };

  const handleEdit = (task: Tasks) => {
    const updatedTask = {
      ...task,
      name: changeName,
      status: changedStatus,
      deadline: changedDeadline,
    };

    putTasks(updatedTask)
      .then(() => setEditTask((prev) => !prev))
      .then((i) =>
        getAllTasks()
          .then(setTasks)
          .catch((error) => console.error("error fetching tasks:", error))
      )
      .catch((error) => console.error("error updating tasks:" + error));
    setChangeName(changeName);
    setChangedDeadline(task.deadline);

    console.log("finished");
  };

  const formatDate = (date: Date): string => {
    const day = date.getDate().toString().padStart(2, "0");
    const month = (date.getMonth() + 1).toString().padStart(2, "0");
    const year = date.getFullYear();
    return `${day} / ${month} / ${year}`;
  };

  return (
    <>
      <div className="container">
        <h1 className="title">Task List</h1>
        <NavBar
          setTasks={setTasks}
          addTaskPage={addTaskPage}
          setAddTaskPage={setAddTaskPage}
          labels={labels}
        />
        <table className="table">
          <thead>
            <tr>
              <th>
                <div className="heading-div">
                  <div className="icons">
                    <BiSolidRename />
                  </div>
                  <div>Task name</div>
                </div>
              </th>
              <th>
                <div className="heading-div">
                  <div className="icons">
                    <PiSpinnerLight />
                  </div>
                  <div>Status</div>
                </div>
              </th>
              <th>
                <div className="heading-div">
                  <div className="icons">
                    <BsCalendar2Day />
                  </div>
                  <div>Due</div>
                </div>
              </th>
              <th>
                <div className="heading-div">
                  <div className="icons">
                    <BiCalendarHeart />
                  </div>
                  <div>Date created</div>
                </div>
              </th>
            </tr>
          </thead>
          <tbody>
            {tasks.map((task) => (
              <tr className="row" key={task.id}>
                <td>
                  {editTask === task.id ? (
                    <input
                      className="input-name"
                      defaultValue={task.name}
                      autoFocus={true}
                      onChange={(e) => setChangeName(e.target.value)}
                    />
                  ) : (
                    <span onDoubleClick={() => setEditTask(task.id)}>
                      {task.name}
                    </span>
                  )}
                </td>
                <td>
                  {editTask === task.id ? (
                    <StatusDropdown
                      labels={labels}
                      status={task.status}
                      changedStatus={changedStatus}
                      setChangedStatus={setChangedStatus}
                    />
                  ) : (
                    <span
                      onClick={() => setEditTask(task.id)}
                      className={`fimini label-${task.status
                        .toLowerCase()
                        .replace(/\s/g, "-")}`}
                    >
                      {task.status}
                    </span>
                  )}
                </td>
                <td>
                  {editTask === task.id ? (
                    <div>
                      <input
                        type="date"
                        defaultValue={formatDate(new Date(task.deadline))}
                        className="datebox"
                        onChange={(e) =>
                          setChangedDeadline(() => e.target.value)
                        }
                        onBlur={() => {
                          // Update the task name when focus is lost
                          task.deadline = changedDeadline;
                        }}
                      />
                    </div>
                  ) : (
                    <span onDoubleClick={() => setEditTask(task.id)}>
                      {formatDate(new Date(task.deadline))}
                    </span>
                  )}
                </td>

                <td>{formatDate(new Date(task.created_date))}</td>
                {editTask === task.id ? (
                  <div className="delete-btn">
                    <button
                      style={{ backgroundColor: "#b5dfcf" }}
                      onClick={() => handleEdit(task)}
                    >
                      <TiTickOutline />
                    </button>
                  </div>
                ) : (
                  <div className="delete-btn">
                    <button onClick={() => handleDelete(task.id)}>
                      <MdDelete />
                    </button>
                  </div>
                )}
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </>
  );
};

export default View;
