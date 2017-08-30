package edu.bionic.service.impl;

import edu.bionic.dao.ProjectDao;
import edu.bionic.dao.TaskDao;
import edu.bionic.domain.Task;
import edu.bionic.service.TaskService;
import edu.bionic.util.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by denis on 29.08.17.
 */
@Service
public class TaskServiceImpl implements TaskService {

    private TaskDao taskDao;

    public TaskServiceImpl(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    @Override
    public List<Task> getAll() {
        return taskDao.getAll();
    }

    @Override
    public Task getById(int taskId) {
        return taskDao.getById(taskId).
                orElseThrow(() -> new NotFoundException(String.format("Задача с id=%d не найден", taskId)));
    }

    @Override
    public Task create(Task task) {
        return taskDao.save(task);
    }

    @Override
    public void update(Task task) {
        taskDao.save(task);
    }

    @Override
    public void delete(Integer taskId) {
        taskDao.delete(taskId);
    }
}
