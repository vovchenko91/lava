package edu.bionic.dao;

import edu.bionic.domain.Task;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * Created by denis on 29.08.17.
 */
public interface TaskDao {

    List<Task> getAll();

    List<Task> getAllByProjectId(int projectId);

    List<Task> getByUserId(int userId, int projectId);

    List<Task> getAllSortedByName(String name, boolean desc, int offset, int limit, int projectId);

    int getCount(String name, int projectId);

    Optional<Task> getById(int taskId);

    Task save(Task task);

    boolean delete(int taskId);
}
