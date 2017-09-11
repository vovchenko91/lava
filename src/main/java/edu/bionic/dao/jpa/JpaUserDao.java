package edu.bionic.dao.jpa;

import edu.bionic.dao.UserDao;
import edu.bionic.domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

/**
 * Created by denis on 29.08.17.
 */
@Repository
@Transactional(readOnly = true)
public class JpaUserDao implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public User save(User user) {
        if (user.getId() == null) {
            entityManager.persist(user);
            return user;
        } else {
            return entityManager.merge(user);
        }
    }

    @Override
    public List<User> getAll() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public Optional<User> getById(int userId) {
        return Optional.ofNullable(entityManager.find(User.class, userId));
    }

    @Override
    public Optional<User> getByEmail(String email) {
        User user = entityManager.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class)
                .setParameter("email", email)
                .getSingleResult();
        return Optional.ofNullable(user);
    }

    @Override
    @Transactional
    public boolean delete(int userId) {
        Query query = entityManager.createQuery("DELETE FROM User u WHERE u.id = :user_id");
        query.setParameter("user_id", userId);

        return (query.executeUpdate() != 0);
    }
}
