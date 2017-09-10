package edu.bionic.service;

import edu.bionic.domain.Task;
import edu.bionic.dto.TaskSort;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by denis on 29.08.17.
 */
public interface TaskService {

    List<Task> getAll();

    List<Task> getAll(String name, String assignee, TaskSort taskSort, int offset, int limit, int projectId);

    List<Task> getAllByProjectId(int projectId);

    Task getById(int taskId);

    int getCount(String name, String assignee, int projectId);

    List<Task> getByUserId(int userId, int projectId);

    Task create(Task task);

    void update(Task task);

    void delete(Integer taskId);
}
