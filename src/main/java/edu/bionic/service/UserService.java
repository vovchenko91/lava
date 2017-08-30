package edu.bionic.service;

import edu.bionic.domain.User;

import java.util.Optional;

/**
 * Created by denis on 29.08.17.
 */
public interface UserService {

    User registerNewUser(User user);

    Optional<User> getAuthenticatedUser();
}
