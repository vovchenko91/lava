package edu.bionic.testdata;

import com.google.common.collect.Lists;
import edu.bionic.domain.Comment;
import edu.bionic.domain.Task;
import edu.bionic.domain.User;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

/**
 * Created by denis on 10.09.17.
 */
public class CommentFactory {

    public static Comment getComment1() {
        return new Comment(
                1,
                new Task(1),
                new User(1),
                LocalDateTime.of(2016, Month.DECEMBER, 28, 13, 0),
                "Нужно проверить на Windows Server"
        );
    }

    public static Comment getComment2() {
        return new Comment(
                2,
                new Task(2),
                new User(1),
                LocalDateTime.of(2017, Month.MARCH, 12, 15, 0),
                "Не получается воспроизвести"
        );
    }

    public static Comment getComment3() {
        return new Comment(
                3,
                new Task(1),
                new User(2),
                LocalDateTime.of(2017, Month.APRIL, 5, 10, 30),
                "Что-то не так с этой задачей"
        );
    }

    public static List<Comment> getCommentsForTask1() {
        return Lists.newArrayList(getComment1(), getComment3());
    }

    public static Comment getNewCommentForTask1() {
        return new Comment(
                null,
                new Task(1),
                new User(2),
                LocalDateTime.of(2017, Month.AUGUST, 11, 11, 11),
                "Что-то не могу воспроизвести"
        );
    }
}

