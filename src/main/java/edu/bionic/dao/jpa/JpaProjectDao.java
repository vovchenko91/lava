package edu.bionic.dao.jpa;

import edu.bionic.dao.ProjectDao;
import edu.bionic.domain.Project;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
    public Optional<Project> getById(int projectId) {
        Project project = entityManager.find(Project.class, projectId);
        return Optional.ofNullable(project);
    }

    @Override
    @Transactional
    public Project save(Project project) {
        if (project.getId() == null) {
            entityManager.persist(project);
            return project;
        } else {
            return entityManager.merge(project);
        }
    }

    @Override
    @Transactional
    public boolean delete(int projectId) {
        Query query = entityManager.createQuery("DELETE FROM Project p WHERE p.id = :project_id");
        query.setParameter("project_id", projectId);

        return query.executeUpdate() != 0;
    }
}
