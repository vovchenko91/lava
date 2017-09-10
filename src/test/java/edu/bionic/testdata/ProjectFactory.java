package edu.bionic.testdata;

import com.google.common.collect.Lists;
import edu.bionic.domain.*;

import java.util.List;

/**
 * Created by denis on 10.09.17.
 */
public class ProjectFactory {

    public static Project getProject1() {
        return new Project(
                1,
                "Front-End Project"
        );
    }

    public static Project getProject2() {
        return new Project(
                2,
                "Back-End Project"
        );
    }

    public static List<Project> getAllProjects() {
        return Lists.newArrayList(
                getProject1(),
                getProject2()
        );
    }

    public static Project newProject() {
        return new Project(
                null,
                "A new project"
        );
    }

    public static Project getProject2Updated() {
        return new Project(
                2,
                "Back-End Project: Updated"
        );
    }
}
