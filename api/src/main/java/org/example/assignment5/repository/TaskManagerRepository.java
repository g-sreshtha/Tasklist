package org.example.assignment5.repository;

import org.example.assignment5.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

// makes queries and stuff
@Repository
public interface TaskManagerRepository extends JpaRepository<Task, UUID> {
// task is obviously the thing that we're adding to the database and Long is the type of the primary key which is the id
    public Optional<Task> findByName(String name);
    public List<Task> findByStatus(String Status);
}
