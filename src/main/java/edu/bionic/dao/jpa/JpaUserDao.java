package edu.bionic.dao.jpa;

import edu.bionic.dao.UserDao;
import edu.bionic.domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

/**
 * Created by denis on 29.08.17.
 */
@Repository
@Transactional(readOnly = true)
public class JpaUserDao implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public Optional<User> getById(int userId) {
        return null;
    }

    @Override
    public Optional<User> getByEmail(String email) {
        return null;
    }
}
