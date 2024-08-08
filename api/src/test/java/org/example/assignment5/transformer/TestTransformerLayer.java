package org.example.assignment5.transformer;

import org.example.assignment5.domain.TaskDomain;
import org.example.assignment5.dto.TaskDto;
import org.example.assignment5.entity.Task;
import org.example.assignment5.tranformer.TaskTransformer;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.example.assignment5.testhelper.TaskListTestHelper.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TestTransformerLayer {

    @Test
    public void DtoToDomain_testEquivalenceAndInstance(){
        TaskDomain taskDomain = TaskTransformer.transformDtoToDomain(TASK_DTO_1);
        assertThat(taskDomain).isInstanceOf(TaskDomain.class);
        assertNull(taskDomain.getId());
        assertEquals(taskDomain.getName(), TASK_DTO_1.getName());
        assertEquals(taskDomain.getDeadline(), TASK_DTO_1.getDeadline());
        assertEquals(taskDomain.getStatus(), TASK_DTO_1.getStatus());
        assertNull(taskDomain.getCreated_date());
    }

    @Test
    public void DomainToDto_testEquivalenceAndInstance(){
        TaskDto taskDto = TaskTransformer.transformDomainToDto(TASK_DOMAIN_1);
        assertThat(taskDto).isInstanceOf(TaskDto.class);
        assertEquals(taskDto.getId(), TASK_DOMAIN_1.getId());
        assertEquals(taskDto.getName(), TASK_DOMAIN_1.getName());
        assertEquals(taskDto.getDeadline(), TASK_DOMAIN_1.getDeadline());
        assertEquals(taskDto.getCreated_date(), TASK_DOMAIN_1.getCreated_date());
        assertEquals(taskDto.getStatus(), TASK_DOMAIN_1.getStatus());
    }

    @Test
    public void EntityToDomain_testEquivalenceAndInstance(){
        TaskDomain taskDomain = TaskTransformer.transformEntityToDomain(TASK_ENTITY_1);
        assertThat(taskDomain).isInstanceOf(TaskDomain.class);
        assertEquals(taskDomain.getId(), TASK_ENTITY_1.getId());
        assertEquals(taskDomain.getName(), TASK_ENTITY_1.getName());
        assertEquals(taskDomain.getDeadline(), TASK_ENTITY_1.getDeadline());
        assertEquals(taskDomain.getCreated_date(), TASK_ENTITY_1.getCreated_date());
        assertEquals(taskDomain.getStatus(), TASK_ENTITY_1.getStatus());
    }

    @Test
    public void DomainToEntity_testEquivalenceAndInstance(){
        Task task = TaskTransformer.transformDomainToEntity(TASK_DOMAIN_1);
        assertThat(task).isInstanceOf(Task.class);
        assertNull(task.getId());
        assertEquals(task.getName(), TASK_DOMAIN_1.getName());
        assertEquals(task.getDeadline(), TASK_DOMAIN_1.getDeadline());
        assertEquals(task.getStatus(), TASK_DOMAIN_1.getStatus());

        assertNull(task.getCreated_date());
    }


}
