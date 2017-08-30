package edu.bionic.dao.jpa;

import edu.bionic.dao.CommentDao;
import edu.bionic.domain.Comment;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by denis on 29.08.17.
 */
@Repository
@Transactional(readOnly = true)
public class JpaCommentDao implements CommentDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Comment> getByTask(int taskId) {
        return null;
    }

    @Override
    public Comment save(Comment comment) {
        return null;
    }
}
