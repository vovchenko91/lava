package edu.bionic.dao.jpa;

import edu.bionic.dao.TaskDao;
import edu.bionic.domain.Task;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
        return null;
    }

    @Override
    public int getCount(String name, BigDecimal min, BigDecimal max) {
        return 0;
    }

    @Override
    public Optional<Task> getById(int taskId) {
        return null;
    }

    @Override
    public Task save(Task task) {
        return null;
    }

    @Override
    public boolean delete(int taskId) {
        return false;
    }
}
