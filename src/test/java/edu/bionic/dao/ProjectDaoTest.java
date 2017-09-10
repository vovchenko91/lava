package edu.bionic.dao;

import edu.bionic.domain.Project;
import edu.bionic.testdata.ProjectFactory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by denis on 10.09.17.
 */
public class ProjectDaoTest extends BaseDaoTest {

    @Autowired
    private ProjectDao projectDao;

    @Test
    public void getAll() throws Exception {
        List<Project> expected = ProjectFactory.getAllProjects();
        List<Project> actual = projectDao.getAll();

        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void getById() throws Exception {
        Project expected = ProjectFactory.getProject1();
        Project actual = projectDao.getById(1).get();

        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void saveNew() throws Exception {
        Project newProject = ProjectFactory.newProject();
        Project savedProject = projectDao.save(newProject);
        newProject.setId(savedProject.getId());

        List<Project> expected = ProjectFactory.getAllProjects();
        expected.add(newProject);
        List<Project> actual = projectDao.getAll();

        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void saveUpdate() throws Exception {
        Project projectToUpdate = ProjectFactory.getProject2Updated();
        Project updatedProject = projectDao.save(projectToUpdate);
        Assert.assertEquals(projectToUpdate.toString(), updatedProject.toString());

        Project updatedProjectFromDB = projectDao.getById(2).get();
        Assert.assertEquals(projectToUpdate.toString(), updatedProjectFromDB.toString());
    }

    @Test
    public void delete() throws Exception {
        boolean isDeleted = projectDao.delete(2);
        Assert.assertEquals(isDeleted, true);

        List<Project> expected = ProjectFactory.getAllProjects()
                .stream().filter(project -> project.getId() != 2).collect(Collectors.toList());
        List<Project> actual = projectDao.getAll();

        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void deleteNotFound() throws Exception {
        boolean isDeleted = projectDao.delete(1000);
        Assert.assertEquals(isDeleted, false);
    }
}
