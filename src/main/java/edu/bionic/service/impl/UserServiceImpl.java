package edu.bionic.service.impl;

import edu.bionic.domain.User;
import edu.bionic.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by denis on 29.08.17.
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public User registerNewUser(User user) {
        return null;
    }

    @Override
    public Optional<User> getAuthenticatedUser() {
        return null;
    }
}
