package edu.bionic.service.impl;

import edu.bionic.dao.ProjectDao;
import edu.bionic.domain.Project;
import edu.bionic.service.ProjectService;
import edu.bionic.util.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by denis on 29.08.17.
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    private ProjectDao projectDao;

    public ProjectServiceImpl(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    @Override
    public List<Project> getAll() {
        return projectDao.getAll();
    }

    @Override
    public Project getById(int projectId) {
        return projectDao.getById(projectId).
                orElseThrow(() -> new NotFoundException(String.format("Проект с id=%d не найден", projectId)));
    }

    @Override
    public Project create(Project project) {
        return projectDao.save(project);
    }

    @Override
    public void update(Project project) {
        projectDao.save(project);
    }

    @Override
    public void delete(Integer projectId) {
        projectDao.delete(projectId);
    }
}
