//package org.example.assignment5.service;
//
//import org.example.assignment5.domain.TaskDomain;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.sql.Timestamp;
//import java.util.Date;
//import java.util.List;
//import java.util.Optional;
//import java.util.UUID;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.example.assignment5.testhelper.TaskListTestHelper.*;
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//public class ServiceLayerTest {
//
//    private final TaskManagerService taskManagerService;
//
//    @Autowired
//    public ServiceLayerTest(TaskManagerService taskManagerService) {
//        this.taskManagerService = taskManagerService;
//    }
//
//    @BeforeEach
//    public void setup(){
//        taskManagerService.addTask(TASK_DOMAIN_1);
//        taskManagerService.addTask(TASK_DOMAIN_2);
//    }
//
//    @AfterEach
//    public void tearDown() {
//        taskManagerService.deleteAll();
//    }
//
//    @Test
//    public void testGetTaskByName(){ //no cus you need to check if the values are present, not if its there or not
//        assertTrue(taskManagerService.getTaskByName(NAME_1).isPresent());
//    }
//
//    @Test
//    public void testGetAllTasks(){
//        List<TaskDomain> taskList = taskManagerService.getAllTasks();
//        // do i assert true that it returns a list or assertEquals to what i expect the output to be??????
//        assertThat(taskList)
//                .usingRecursiveComparison()
//                .ignoringFields("id", "created_date")
//                .ignoringOverriddenEqualsForTypes(TaskDomain.class)
//                .isEqualTo(List.of(TASK_DOMAIN_1, TASK_DOMAIN_2));
//
//    }
////    @Test
////    public void testGetTaskById(){ //??????? why
////
////
////        Optional<TaskDomain> result = taskManagerService.getTaskById(uuid);
////        assertTrue(result.isEmpty());
////    }
//
////    @Test
////    public void testDeleteTaskId_shouldAssertTrueWhenFindByIdIsFalse(){
////        UUID id = TASK_DOMAIN_1.getId();
////        assertTrue(taskManagerService.deleteTaskById(id));
////    }
//
//
//
//}
