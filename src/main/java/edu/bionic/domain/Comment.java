package edu.bionic.domain;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by denis on 29.08.17.
 */
@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @Access(AccessType.PROPERTY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id")
    private Task task;

    @NotBlank(message = "Имя не должно быть пустым")
    private String author;
    private LocalDateTime dateTime;

    @NotBlank(message = "Комментарий не должен быть пустым")
    private String text;

    public Comment(Integer id, Task task, String author, LocalDateTime dateTime, String text, Integer rating) {
        this.id = id;
        this.task = task;
        this.author = author;
        this.dateTime = dateTime;
        this.text = text;
    }

    public Comment() {
        this.task = new Task();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comment = (Comment) o;

        if (id != null ? !id.equals(comment.id) : comment.id != null) return false;
        if (task != null ? !task.equals(comment.task) : comment.task != null) return false;
        if (author != null ? !author.equals(comment.author) : comment.author != null) return false;
        return !(dateTime != null ? !dateTime.equals(comment.dateTime) : comment.dateTime != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (task != null ? task.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (dateTime != null ? dateTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", task=" + task +
                ", author='" + author + '\'' +
                ", dateTime=" + dateTime +
                ", text='" + text + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
