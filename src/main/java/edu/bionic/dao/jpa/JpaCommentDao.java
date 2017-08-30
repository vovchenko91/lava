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
        return entityManager.createQuery("SELECT c FROM Comment c WHERE c.task.id = :task_id", Comment.class)
                .setParameter("task_id", taskId)
                .getResultList();
    }

    @Override
    @Transactional
    public Comment save(Comment comment) {
        if (comment.getId() == null) {
            entityManager.persist(comment);
            return comment;
        } else {
            return entityManager.merge(comment);
        }
    }
}
