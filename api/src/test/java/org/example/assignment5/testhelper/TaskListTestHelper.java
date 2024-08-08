package org.example.assignment5.testhelper;

import org.example.assignment5.domain.TaskDomain;
import org.example.assignment5.dto.TaskDto;
import org.example.assignment5.entity.Task;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;

import java.sql.Timestamp;
import java.util.Map;
import java.util.UUID;

public class TaskListTestHelper {

    public static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS+00:00");
    public static String NAME_1 = "name1";
    public static String NAME_2 = "name2";
    public static String NAME_3 = "name3";
    public static String STATUS_1 = "status1";
    public static String STATUS_2 = "status2";
    public static String STATUS_3 = "status3";
    public static UUID UUID_1 = UUID.randomUUID();
    public static UUID UUID_2 = UUID.randomUUID();
    public static Timestamp CREATED_TIMESTAMP_1 = new Timestamp(100000);
    public static Timestamp CREATED_TIMESTAMP_2 = new Timestamp(111111);
    public static Timestamp DEADLINE_TIMESTAMP_1 = new Timestamp(222222);
    public static Timestamp DEADLINE_TIMESTAMP_2 = new Timestamp(333333);
    public static final Task TASK_ENTITY_1 = new Task(NAME_1, DEADLINE_TIMESTAMP_1, STATUS_1);
    public static final TaskDomain TASK_DOMAIN_1 = new TaskDomain(UUID_1, NAME_1, DEADLINE_TIMESTAMP_1, CREATED_TIMESTAMP_1, STATUS_1);
    public static final TaskDomain TASK_DOMAIN_2 = new TaskDomain(UUID_2, NAME_2, DEADLINE_TIMESTAMP_2, CREATED_TIMESTAMP_2, STATUS_2);
    public static final TaskDto TASK_DTO_1 = new TaskDto(UUID_1, NAME_1, DEADLINE_TIMESTAMP_1, CREATED_TIMESTAMP_1, STATUS_1);
    public static final TaskDto TASK_DTO_2 = new TaskDto(UUID_2, NAME_2, DEADLINE_TIMESTAMP_2, CREATED_TIMESTAMP_2, STATUS_2);
    public static final Map<String, ? extends Serializable> TASK_JSON = Map.ofEntries(
            Map.entry("name", NAME_1),
            Map.entry("deadline", DEADLINE_TIMESTAMP_1),
            Map.entry("status", STATUS_1)
    );


}
