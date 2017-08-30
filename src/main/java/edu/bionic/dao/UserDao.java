package edu.bionic.dao;

import edu.bionic.domain.User;

import java.util.List;
import java.util.Optional;

/**
 * Created by denis on 29.08.17.
 */
public interface UserDao {

    User save(User user);

    List<User> getAll();

    Optional<User> getById(int userId);

    Optional<User> getByEmail(String email);

    boolean delete(int userId);
}
