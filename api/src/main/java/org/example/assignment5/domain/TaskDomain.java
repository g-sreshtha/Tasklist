package org.example.assignment5.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@ToString
public class TaskDomain {
//carries data between processes
    @JsonIgnore
    public UUID id;
    private String name;
    private Date deadline;
    @JsonIgnore
    private Date created_date;
    @JsonInclude
    private String status;

    public TaskDomain(UUID id, String name, Date deadline, Date created_date, String status) {
        this.id = id;
        this.name = name;
        this.deadline = deadline;
        this.created_date = created_date;
        this.status = status;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskDomain that = (TaskDomain) o;
        return (Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(deadline, that.deadline) && Objects.equals(created_date, that.created_date) && Objects.equals(status, that.status));
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, deadline, created_date, status);
    }
}
