package edu.bionic.service;

import edu.bionic.domain.Task;

import java.util.List;

/**
 * Created by denis on 29.08.17.
 */
public interface TaskService {

    List<Task> getAll();

    List<Task> getAllByProjectId(int projectId);

    Task getById(int taskId);

    Task create(Task task);

    void update(Task task);

    void delete(Integer taskId);
}
