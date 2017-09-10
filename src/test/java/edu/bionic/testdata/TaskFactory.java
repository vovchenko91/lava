package edu.bionic.testdata;

import com.google.common.collect.Lists;
import edu.bionic.domain.*;

import java.util.List;

/**
 * Created by denis on 10.09.17.
 */
public class TaskFactory {

    public static Task getTask1() {
        return new Task(
                1,
                new Project(1),
                "BR File upload: if first choose is Any - Add condition activated",
                Type.TASK,
                Status.OPEN,
                Priority.HIGH,
                "steps: 1,2,3",
                new User(1),
                new User(2)
        );
    }

    public static Task getTask2() {
        return new Task(
                2,
                new Project(1),
                "BR Visited webpage: condition Webpage URL and Time Idle/Active do not work in conjunction",
                Type.TASK,
                Status.OPEN,
                Priority.HIGH,
                "steps: 1,2,3,4",
                new User(2),
                new User(1)
        );
    }

    public static Task getTask3() {
        return new Task(
                3,
                new Project(1),
                "Uploaded Big files via OneDrive (office365) do not appear in File transfers report",
                Type.TASK,
                Status.OPEN,
                Priority.HIGH,
                "steps: 1,2",
                new User(2),
                new User(1)
        );
    }

    public static List<Task> getAllTasks() {
        return Lists.newArrayList(
                getTask1(),
                getTask2(),
                getTask3()
        );
    }

    public static Task newTask() {
        return new Task(
                null,
                new Project(2),
                "Uploaded small files",
                Type.TASK,
                Status.OPEN,
                Priority.HIGH,
                "steps: 1,2",
                new User(1),
                new User(1)
        );
    }

    public static Task getTask2Updated() {
        return new Task(
                2,
                new Project(1),
                "BR Visited webpage: (Changed)",
                Type.TASK,
                Status.INPROGRESS,
                Priority.HIGH,
                "steps: 1,2,3,4",
                new User(2),
                new User(1)
        );
    }
}
