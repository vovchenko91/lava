package edu.bionic.service;

import edu.bionic.domain.Comment;

import java.util.List;

/**
 * Created by denis on 29.08.17.
 */
public interface CommentService {

    List<Comment> getByProject(int projectId);

    void createNew(Comment comment);

}
