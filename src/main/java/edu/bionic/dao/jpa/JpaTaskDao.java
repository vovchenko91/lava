package edu.bionic.dao.jpa;

import edu.bionic.dao.TaskDao;
import edu.bionic.domain.Task;
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
public class JpaTaskDao implements TaskDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Task> getAll() {
        return entityManager.createQuery("SELECT t FROM Task t", Task.class)
                .getResultList();
    }

    @Override
    public List<Task> getAllByProjectId(int projectId) {
        return entityManager.createQuery("SELECT t FROM Task t WHERE t.project.id = :project_id", Task.class)
                .setParameter("project_id", projectId)
                .getResultList();
    }

    @Override
    public List<Task> getByUserId(int userId, int projectId) {
        return entityManager.createQuery("SELECT t FROM Task t WHERE t.assignee.id = :assignee_id " +
                "AND t.project.id = :project_id", Task.class)
                .setParameter("assignee_id", userId)
                .setParameter("project_id", projectId)
                .getResultList();
    }

    @Override
    public List<Task> getAllSortedByName(String name, boolean desc, int offset, int limit, int projectId) {
        TypedQuery<Task> query = this.entityManager.createQuery("SELECT t FROM Task t " +
                "WHERE t.name LIKE :name " +
                "AND t.project.id = :project_id " +
                "ORDER BY t.name " + (desc ? "DESC " : "ASC "), Task.class);

        query.setParameter("project_id", projectId);
        query.setParameter("name", StringUtils.isEmpty(name) ? "%" : "%" + name + "%");
        query.setFirstResult(offset);
        query.setMaxResults(limit);

        return query.getResultList();
    }

    @Override
    public int getCount(String name, int projectId) {
        TypedQuery<Long> query = this.entityManager.createQuery("SELECT COUNT(t) FROM Task t " +
                "WHERE t.name LIKE :name AND t.project.id = :project_id", Long.class);
        query.setParameter("project_id", projectId);
        query.setParameter("name", StringUtils.isEmpty(name) ? "%" : "%" + name + "%");

        return query.getSingleResult().intValue();
    }

    @Override
    public Optional<Task> getById(int taskId) {
        Task task = entityManager.find(Task.class, taskId);
        return Optional.ofNullable(task);
    }

    @Override
    @Transactional
    public Task save(Task task) {
        if (task.getId() == null) {
            entityManager.persist(task);
            return task;
        } else {
            return entityManager.merge(task);
        }
    }

    @Override
    @Transactional
    public boolean delete(int taskId) {
        Query query = entityManager.createQuery("DELETE FROM Task t WHERE t.id = :task_id");
        query.setParameter("task_id", taskId);

        return query.executeUpdate() != 0;
    }
}
