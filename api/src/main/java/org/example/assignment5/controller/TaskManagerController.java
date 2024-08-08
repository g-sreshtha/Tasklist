package org.example.assignment5.controller;

import org.apache.catalina.connector.Response;
import org.example.assignment5.dto.TaskDto;
import org.example.assignment5.repository.TaskManagerRepository;
import org.example.assignment5.service.TaskManagerService;
import org.example.assignment5.tranformer.TaskTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RequestMapping("/api/v1/tasks")
@RestController
public class TaskManagerController {
    private final TaskManagerService taskManagerService;

    public TaskManagerController(TaskManagerService taskManagerService){
        this.taskManagerService = taskManagerService;
    }

    //get by id - ok / not found
    @GetMapping("/{id}") // two possible responses
    public ResponseEntity<TaskDto> getTasksUsingId(@PathVariable final UUID id){
        var optionalTask = taskManagerService.getTaskById(id);
        if(optionalTask.isPresent()){
            var task = optionalTask.get();
            //in the service we use taskDomain whereas here weve got dto, so we need to transform dto -> domain
            return ResponseEntity.ok(TaskTransformer.transformDomainToDto(task));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getAll")// two possible responses
    public ResponseEntity<List<TaskDto>> getAll(){
        return ResponseEntity.ok(taskManagerService.getAllTasks()
                .stream()
                .map(TaskTransformer::transformDomainToDto)
                .toList());
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<TaskDto>> getTaskByStatus(@PathVariable String status){
        return ResponseEntity.ok(taskManagerService.getTaskByStatus(status)
                .stream().map(TaskTransformer::transformDomainToDto).toList());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<TaskDto> getTaskByName(@PathVariable String name){
        var optionalTask = (taskManagerService.getTaskByName(name));
        if(optionalTask.isPresent()){
            var task = optionalTask.get();
            return ResponseEntity.ok(TaskTransformer.transformDomainToDto(task));
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    //Post - Created
    @PostMapping("/create")
    public ResponseEntity<TaskDto> createTask(@RequestBody final TaskDto taskDto){
        return ResponseEntity.ok().body(TaskTransformer.transformDomainToDto(taskManagerService.addTask(TaskTransformer.transformDtoToDomain(taskDto))));
    }

    //Put - Ok(update) / not found
    @PutMapping("/{id}")
    public ResponseEntity<TaskDto> updateTask(@PathVariable final UUID id, @RequestBody final TaskDto taskDto){
        if (taskManagerService.updateTask(id, TaskTransformer.transformDtoToDomain(taskDto))){
            return ResponseEntity.ok(taskDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Delete no content /
    @CrossOrigin(origins = "/api/v1/tasks")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<TaskDto> deleteTask(@PathVariable final UUID id){
        if (taskManagerService.deleteTaskById(id)){
            return ResponseEntity.noContent().build();
        } else{
            return ResponseEntity.notFound().build();
        }
    }

}
