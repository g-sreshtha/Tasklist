package org.example.assignment5.entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.*;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;
import java.util.UUID;

import static org.hibernate.generator.EventType.INSERT;

@Setter
@Getter
@Entity
@Table(name = "task")
public class Task {


    //setters and getters
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name ="name")
    private String name;

    @Column(name = "deadline")
    private Date deadline;

    @Column(name = "status")
    private String status;

    @Column(name = "created_date")
    @CreationTimestamp
    private Date created_date;


    public Task(String name, Date deadline, String status) {
        this.name = name;
        this.deadline = deadline;
        this.status = status;

    }

    public Task() {

    }
}
