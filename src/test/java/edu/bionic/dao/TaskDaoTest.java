package edu.bionic.dao;

import edu.bionic.domain.Task;
import edu.bionic.testdata.TaskFactory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by denis on 10.09.17.
 */
public class TaskDaoTest extends BaseDaoTest {

    @Autowired
    private TaskDao taskDao;

    @Test
    public void getAll() throws Exception {
        List<Task> expected = TaskFactory.getAllTasks();
        List<Task> actual = taskDao.getAll();

        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void getById() throws Exception {
        Task expected = TaskFactory.getTask1();
        Task actual = taskDao.getById(1).get();

        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void saveNew() throws Exception {
        Task newTask = TaskFactory.newTask();
        Task savedTask = taskDao.save(newTask);
        newTask.setId(savedTask.getId());

        List<Task> expected = TaskFactory.getAllTasks();
        expected.add(newTask);
        List<Task> actual = taskDao.getAll();

        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void saveUpdate() throws Exception {
        Task taskToUpdate = TaskFactory.getTask2Updated();
        Task updatedTask = taskDao.save(taskToUpdate);
        Assert.assertEquals(taskToUpdate.toString(), updatedTask.toString());

        Task updatedTaskFromDB = taskDao.getById(2).get();
        Assert.assertEquals(taskToUpdate.toString(), updatedTaskFromDB.toString());
    }

    @Test
    public void delete() throws Exception {
        boolean isDeleted = taskDao.delete(3);
        Assert.assertEquals(isDeleted, true);

        List<Task> expected = TaskFactory.getAllTasks()
                .stream().filter(task -> task.getId() != 3).collect(Collectors.toList());
        List<Task> actual = taskDao.getAll();

        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void deleteNotFound() throws Exception {
        boolean isDeleted = taskDao.delete(1000);
        Assert.assertEquals(isDeleted, false);
    }

}
