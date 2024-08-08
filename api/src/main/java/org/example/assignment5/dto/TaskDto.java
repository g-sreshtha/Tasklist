package org.example.assignment5.dto;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString

//carries data between processes
public class TaskDto {

    private UUID id;
    private String name;
    private Date deadline;
    private Date created_date;
    private String status;

    public TaskDto(UUID id, String name, Date deadline, Date created_date, String status) {
        this.id = id;
        this.name = name;
        this.deadline = deadline;
        this.created_date = created_date;
        this.status = status;
    }

}
