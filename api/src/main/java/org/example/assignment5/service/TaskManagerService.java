package org.example.assignment5.service;

import org.example.assignment5.domain.TaskDomain;
import org.example.assignment5.dto.TaskDto;
import org.example.assignment5.entity.Task;
import org.example.assignment5.repository.TaskManagerRepository;
import org.example.assignment5.tranformer.TaskTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class TaskManagerService {

    private final TaskManagerRepository taskManagerRepository;

    @Autowired
    public TaskManagerService(TaskManagerRepository taskManagerRepository){
        this.taskManagerRepository = taskManagerRepository;
    }

    public Optional<TaskDomain> getTaskById(UUID id){
        return taskManagerRepository.findById(id).map(TaskTransformer::transformEntityToDomain);
    }

    public TaskDomain addTask(TaskDomain taskDomain){
        return TaskTransformer.transformEntityToDomain(taskManagerRepository.save(TaskTransformer.transformDomainToEntity(taskDomain)));
    }

    //maybe create a get completed

    public Optional<TaskDomain> getTaskByName(String name){
        return taskManagerRepository.findByName(name).map(TaskTransformer::transformEntityToDomain);
    }

    public List<TaskDomain> getAllTasks(){
        return taskManagerRepository.findAll().stream().map(TaskTransformer::transformEntityToDomain).toList();
    }

    public List<TaskDomain> getTaskByStatus(String status){
        return taskManagerRepository.findByStatus(status).stream().map(TaskTransformer::transformEntityToDomain).toList();
    }

    public boolean deleteTaskById(UUID id){
        taskManagerRepository.deleteById(id);
        return taskManagerRepository.findById(id).isEmpty();
    }

    public boolean updateTask(UUID id, TaskDomain updatedDomain){

        var optionalTask = taskManagerRepository.findById(id);
        if(optionalTask.isPresent()){
            var task = optionalTask.get();
            task.setName(updatedDomain.getName());
            task.setDeadline(updatedDomain.getDeadline());
            task.setStatus(updatedDomain.getStatus());

            taskManagerRepository.save(task);
            return true;
        }
        return false;
//        taskManagerRepository.save(TaskTransformer.transformDomainToEntity(taskDomain));
//        return taskManagerRepository.findById(id).isPresent();
    }

    // get task by status;

    public void deleteAll() {
        taskManagerRepository.deleteAll();
    }




}
