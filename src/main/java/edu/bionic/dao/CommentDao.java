package edu.bionic.dao;

import edu.bionic.domain.Comment;

import java.util.List;

/**
 * Created by denis on 29.08.17.
 */
public interface CommentDao {

    List<Comment> getByTask(int taskId);
    Comment save(Comment comment);
}
