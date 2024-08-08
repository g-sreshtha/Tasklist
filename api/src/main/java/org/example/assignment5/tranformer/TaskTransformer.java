package org.example.assignment5.tranformer;

import org.example.assignment5.domain.TaskDomain;
import org.example.assignment5.dto.TaskDto;
import org.example.assignment5.entity.Task;

import java.util.Optional;

public class TaskTransformer {

    public static TaskDto transformDomainToDto(TaskDomain taskDomain){
        return new TaskDto(taskDomain.getId(), taskDomain.getName(), taskDomain.getDeadline(), taskDomain.getCreated_date(), taskDomain.getStatus());
    }

    public static TaskDomain transformDtoToDomain(TaskDto taskDto){
        return new TaskDomain(null, taskDto.getName(), taskDto.getDeadline(), null, taskDto.getStatus());
    }

    public static TaskDomain transformEntityToDomain(Task task){
        return new TaskDomain(task.getId(), task.getName(), task.getDeadline(), task.getCreated_date(), task.getStatus());
    }

    public static Task transformDomainToEntity(TaskDomain taskDomain){
        return new Task(taskDomain.getName(), taskDomain.getDeadline(), taskDomain.getStatus());
    }
}

