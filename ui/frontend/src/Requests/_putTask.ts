import { Task } from "../Task";

export async function putTasks(task: Task) {
  const response = await fetch(
    "http://localhost:8080/api/v1/tasks/" + task.id,
    {
      method: "PUT",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
      body: JSON.stringify(task),
    }
  );
  return await response;
}
