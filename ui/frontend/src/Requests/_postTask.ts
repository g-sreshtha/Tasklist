export async function postTask(data: {
  name: string;
  deadline: Date;
  status: string;
}) {
  const response = await fetch("http://localhost:8080/api/v1/tasks/create", {
    method: "POST",
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
    body: JSON.stringify(data),
  });
  return await response.json();
}
