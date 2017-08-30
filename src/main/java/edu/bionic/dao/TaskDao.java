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

    int getCount(String name, BigDecimal min, BigDecimal max);

    Optional<Task> getById(int taskId);

    Task save(Task task);

    boolean delete(int taskId);
}
