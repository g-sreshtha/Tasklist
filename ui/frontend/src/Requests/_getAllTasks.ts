export async function getAllTasks() {
  const response = await fetch("http://localhost:8080/api/v1/tasks/getAll", {
    method: "GET",
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
  });
  return await response.json();
}
