package edu.bionic.dao.jpa;

import edu.bionic.dao.ProjectDao;
import edu.bionic.domain.Project;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * Created by denis on 29.08.17.
 */
@Repository
@Transactional(readOnly = true)
public class JpaProjectDao implements ProjectDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Project> getAll() {
        return entityManager.createQuery("SELECT p FROM Project p", Project.class)
                .getResultList();
    }

    @Override
    public List<Project> getAllSortedByName(String name, BigDecimal min, BigDecimal max, boolean desc, int offset, int limit) {
        return null;
    }

    @Override
    public Optional<Project> getById(int projectId) {
        Project project = entityManager.find(Project.class, projectId);
        return Optional.ofNullable(project);
    }

    @Override
    public Project save(Project project) {
        return null;
    }

    @Override
    public boolean delete(int projectId) {
        return false;
    }
}
