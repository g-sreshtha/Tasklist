export async function deleteTask(id: string) {
  const response = await fetch(
    "http://localhost:8080/api/v1/tasks/delete/" + id,
    {
      method: "DELETE",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
    }
  );
  return await response;
}
