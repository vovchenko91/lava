package edu.bionic.dao;

import com.google.common.collect.Lists;
import edu.bionic.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static edu.bionic.testdata.UserFactory.*;

/**
 * Created by denis on 10.09.17.
 */
public class UserDaoTest extends BaseDaoTest {


    @Autowired
    private UserDao userDao;

    @Test
    public void save() throws Exception {
        User newUser = getNewUser();
        User savedUser = userDao.save(newUser);
        newUser.setId(savedUser.getId());

        List<User> expected = Lists.newArrayList(getAdmin(), getUser(), getUser2(), newUser);
        List<User> actual = userDao.getAll();

        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void getAll() throws Exception {
        List<User> expected = Lists.newArrayList(getAdmin(), getUser(), getUser2());
        List<User> actual = userDao.getAll();

        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void getById() throws Exception {
        int userId = getUser().getId();

        User expected = getUser();
        User actual = userDao.getById(userId).get();

        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void getByEmail() throws Exception {
        String email = getUser().getEmail();

        User expected = getUser();
        User actual = userDao.getByEmail(email).get();

        Assert.assertEquals(expected.toString(), actual.toString());
    }

}
