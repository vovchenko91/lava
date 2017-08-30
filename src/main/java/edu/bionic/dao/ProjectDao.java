package edu.bionic.dao;

import edu.bionic.domain.Project;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * Created by denis on 29.08.17.
 */
public interface ProjectDao {

    List<Project> getAll();

    List<Project> getAllSortedByName(String name, boolean desc, int offset, int limit);

    Optional<Project> getById(int projectId);

    Project save(Project project);

    boolean delete(int projectId);
}
