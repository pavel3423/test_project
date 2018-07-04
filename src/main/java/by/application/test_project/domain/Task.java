package by.application.test_project.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Data
@Entity
@Table(name = "tasks")
public class Task {

    @JsonIgnore
    private int taskId;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private Type action;
    @Column
    private Status status;
    @Column
    @JsonFormat(locale = "ru", shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Europe/Minsk")
    private Date startTime;
    @Column
    @JsonFormat(locale = "ru", shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Europe/Minsk")
    private Date endTime;

    public Task() {
    }

    public Task(int taskId, String name, String description, Type action, Status status, Date startTime, Date endTime) {
        this.taskId = taskId;
        this.name = name;
        this.description = description;
        this.action = action;
        this.status = status;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Type getAction() {
        return action;
    }

    public void setAction(Type action) {
        this.action = action;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return taskId == task.taskId &&
                Objects.equals(name, task.name) &&
                Objects.equals(description, task.description) &&
                action == task.action &&
                status == task.status &&
                Objects.equals(startTime, task.startTime) &&
                Objects.equals(endTime, task.endTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(taskId, name, description, action, status, startTime, endTime);
    }
}
