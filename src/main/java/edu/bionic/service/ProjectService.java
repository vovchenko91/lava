package edu.bionic.service;

import edu.bionic.domain.Project;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by denis on 29.08.17.
 */
public interface ProjectService {

    List<Project> getAll();

    Project getById(int projectId);

    Project create(Project project);

    void update(Project project);

    void delete(Integer projectId);
}
