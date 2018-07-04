package by.application.test_project.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "executions")
public class Execution {

    private int executionId;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private Status status;
    @Column
    @JsonFormat(locale = "ru", shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Europe/Minsk")
    private Date startTime;
    @Column
    @JsonFormat(locale = "ru", shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Europe/Minsk")
    private Date endTime;
    private List<Task> tasks;

    public Execution() {
    }

    public Execution(int executionId, String name, String description, Status status, Date startTime, Date endTime, List<Task> tasks) {
        this.executionId = executionId;
        this.name = name;
        this.description = description;
        this.status = status;
        this.startTime = startTime;
        this.endTime = endTime;
        this.tasks = tasks;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    public int getExecutionId() {
        return executionId;
    }

    public void setExecutionId(int executionId) {
        this.executionId = executionId;
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

    @OneToMany(cascade = CascadeType.ALL)
    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Execution execution = (Execution) o;
        return executionId == execution.executionId &&
                Objects.equals(name, execution.name) &&
                Objects.equals(description, execution.description) &&
                status == execution.status &&
                Objects.equals(startTime, execution.startTime) &&
                Objects.equals(endTime, execution.endTime) &&
                Objects.equals(tasks, execution.tasks);
    }

    @Override
    public int hashCode() {

        return Objects.hash(executionId, name, description, status, startTime, endTime, tasks);
    }
}
