package edu.bionic.dao;

import edu.bionic.domain.Comment;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static edu.bionic.testdata.CommentFactory.getCommentsForTask1;
import static edu.bionic.testdata.CommentFactory.getNewCommentForTask1;

/**
 * Created by denis on 10.09.17.
 */
public class CommentDaoTest extends BaseDaoTest {

    @Autowired
    private CommentDao commentDao;

    @Test
    public void getByTask() throws Exception {
        List<Comment> expected = getCommentsForTask1();
        List<Comment> actual = commentDao.getByTask(1);

        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void save() throws Exception {
        Comment newComment = getNewCommentForTask1();
        Comment savedComment = commentDao.save(newComment);
        newComment.setId(savedComment.getId());

        List<Comment> expected = getCommentsForTask1();
        expected.add(newComment);

        List<Comment> actual = commentDao.getByTask(1);

        Assert.assertEquals(expected.toString(), actual.toString());
    }

}
