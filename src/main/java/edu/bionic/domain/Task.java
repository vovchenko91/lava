package edu.bionic.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by denis on 29.08.17.
 */
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @Access(AccessType.PROPERTY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;
    @NotBlank(message = "Обязательное поле")
    private String name;
    @NotNull(message = "Обязательное поле")
    private Type type;
    @NotNull(message = "Обязательное поле")
    private Status status;
    @NotNull(message = "Обязательное поле")
    private Priority priority;
    @NotBlank(message = "Обязательное поле")
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assignee_id")
    private User assignee;

    public Task() {
    }

    public Task(Integer id) {
        this.id = id;
    }

    public Task(Integer id, Project project, String name, Type type, Status status, Priority priority, String description, User assignee) {
        this.project = project;
        this.id = id;
        this.name = name;
        this.type = type;
        this.status = status;
        this.priority = priority;
        this.description = description;
        this.assignee = assignee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (id != null ? !id.equals(task.id) : task.id != null) return false;
        if (project != null ? !project.equals(task.project) : task.project != null) return false;
        if (name != null ? !name.equals(task.name) : task.name != null) return false;
        return type == task.type;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (project != null ? project.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", project=" + project +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", status=" + status +
                ", priority=" + priority +
                ", description='" + description + '\'' +
                ", assignee=" + assignee +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getAssignee() {
        return assignee;
    }

    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }

    public String printInfo() {
        return String.format("<span>id: %d</span><h3>%s</h3>", id, name);
    }
}