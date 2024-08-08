//package org.example.assignment5.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.example.assignment5.service.TaskManagerService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.time.ZoneId;
//import java.util.List;
//import java.util.Optional;
//
//import static org.example.assignment5.testhelper.TaskListTestHelper.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class TestControllerLayer {
//
//    @MockBean
//    private TaskManagerService taskManagerService;
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Test
//    public void getTaskUsingID() throws Exception {
//
//        when(taskManagerService.getTaskById(TASK_DTO_1.getId())).thenReturn(Optional.of(TASK_DOMAIN_1));
//
//        mockMvc.perform(get("/api/v1/tasks/{id}", TASK_DTO_1.getId()))
//                .andExpect(jsonPath("id").value(TASK_DTO_1.getId().toString()))
//                .andExpect(jsonPath("name").value(TASK_DTO_1.getName()))
//                .andExpect(jsonPath("deadline").value(TASK_DTO_1.getDeadline().toInstant().atZone(ZoneId.of("UTC")).format(FORMATTER)))
//                .andExpect(jsonPath("created_date").value(TASK_DTO_1.getCreated_date().toInstant().atZone(ZoneId.of("UTC")).format(FORMATTER)))
//                .andReturn();
//
//    }
//
//    @Test
//    public void getAllTasks() throws Exception {
//        when(taskManagerService.getAllTasks()).thenReturn(List.of(TASK_DOMAIN_1, TASK_DOMAIN_2));
//
//        mockMvc.perform(get("/api/v1/tasks/getAll"))
//                .andExpect(jsonPath("[0].id").value(TASK_DTO_1.getId().toString()))
//                .andExpect(jsonPath("[0].name").value(TASK_DTO_1.getName()))
//                .andExpect(jsonPath("[0].deadline").value(TASK_DTO_1.getDeadline().toInstant().atZone(ZoneId.of("UTC")).format(FORMATTER)))
//                .andExpect(jsonPath("[0].created_date").value(TASK_DTO_1.getCreated_date().toInstant().atZone(ZoneId.of("UTC")).format(FORMATTER)))
//                .andExpect(jsonPath("[1].id").value(TASK_DTO_2.getId().toString()))
//                .andExpect(jsonPath("[1].name").value(TASK_DTO_2.getName()))
//                .andExpect(jsonPath("[1].deadline").value(TASK_DTO_2.getDeadline().toInstant().atZone(ZoneId.of("UTC")).format(FORMATTER)))
//                .andExpect(jsonPath("[1].created_date").value(TASK_DTO_2.getCreated_date().toInstant().atZone(ZoneId.of("UTC")).format(FORMATTER)))
//                .andReturn();
//
//    }
//
//    @Test
//    public void createTask() throws Exception {
//
//        when(taskManagerService.addTask(TASK_DOMAIN_1)).thenReturn(TASK_DOMAIN_1);
//        ObjectMapper mapper = new ObjectMapper();
//        mockMvc.perform(post("/api/v1/tasks/create")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON)
//                .content(mapper.writeValueAsString(TASK_DTO_1)))
//                .andExpect(status().is(200))
//                .andReturn();
//
//        verify(taskManagerService).addTask(TASK_DOMAIN_1);
//
//    }
//
//    @Test
//    public void upgradeTask() throws Exception {
//
//    }
//
//    @Test
//    public void deleteTask() throws Exception {
//
//    }



//}
