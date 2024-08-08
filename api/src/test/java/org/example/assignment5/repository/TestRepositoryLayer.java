package org.example.assignment5.repository;

import org.example.assignment5.entity.Task;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.example.assignment5.testhelper.TaskListTestHelper.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TestRepositoryLayer {

    TaskManagerRepository taskManagerRepository;

    @Autowired
    public TestRepositoryLayer(TaskManagerRepository taskManagerRepository) {
        this.taskManagerRepository = taskManagerRepository;
    }

    @BeforeEach
    public void setup(){
        taskManagerRepository.save(TASK_ENTITY_1);
    }

    @AfterEach
    public void tearDown(){
        taskManagerRepository.deleteAll();
    }

    @Test
    public void findByName(){ //again bro here you need to assert if the objects are equal, not just if something is returned
        Optional<Task> task1 = taskManagerRepository.findByName(NAME_1);
        assertTrue(task1.isPresent());
    }
}
