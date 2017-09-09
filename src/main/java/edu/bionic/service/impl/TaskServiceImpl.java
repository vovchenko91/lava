package edu.bionic.service.impl;

import edu.bionic.dao.ProjectDao;
import edu.bionic.dao.TaskDao;
import edu.bionic.domain.Task;
import edu.bionic.dto.TaskSort;
import edu.bionic.service.TaskService;
import edu.bionic.util.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
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
    public List<Task> getAll(String name, TaskSort taskSort, int offset, int limit, int projectId) {
        List<Task> result = new ArrayList<>();
        switch (taskSort) {
            case NAME_ASC:
            case NAME_DESC:
                result = this.taskDao.getAllSortedByName(name, taskSort == TaskSort.NAME_DESC, offset, limit, projectId);
                break;
        }
        return result;
    }

    @Override
    public List<Task> getAllByProjectId(int projectId) {
        return taskDao.getAllByProjectId(projectId);
    }

    @Override
    public Task getById(int taskId) {
        return taskDao.getById(taskId).
                orElseThrow(() -> new NotFoundException(String.format("Задача с id=%d не найден", taskId)));
    }

    @Override
    public int getCount(String name, int projectId) {
        return taskDao.getCount(name, projectId);
    }

    @Override
    public List<Task> getByUserId(int userId, int projectId) {
        return taskDao.getByUserId(userId, projectId);
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
