package edu.bionic.service.impl;

import edu.bionic.dao.UserDao;
import edu.bionic.domain.Role;
import edu.bionic.domain.User;
import edu.bionic.dto.LoggedUser;
import edu.bionic.service.UserService;
import edu.bionic.util.exception.NotFoundException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Created by denis on 29.08.17.
 */
@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private UserDao userDao;

    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserDao userDao,
                           PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        this.userDao = userDao;
    }

    @Override
    public User registerNewUser(User user) {
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User newUser = userDao.save(user);

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(new LoggedUser(newUser),
                        null,
                        Collections.singleton(user.getRole()));
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        return newUser;
    }

    @Override
    public Optional<User> getAuthenticatedUser() {
        return null;
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public User getById(int userId) {
        return userDao.getById(userId).
                orElseThrow(() -> new NotFoundException(String.format("Проект с id=%d не найден", userId)));
    }

    @Override
    public User create(User user) {
        return userDao.save(user);
    }

    @Override
    public void update(User user) {
        userDao.save(user);
    }

    @Override
    public void delete(Integer userId) {
        userDao.delete(userId);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userDao.getByEmail(username);
        return user.map(LoggedUser::new).orElse(null);
    }
}
