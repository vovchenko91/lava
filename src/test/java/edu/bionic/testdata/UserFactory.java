package edu.bionic.testdata;

import edu.bionic.domain.Position;
import edu.bionic.domain.Role;
import edu.bionic.domain.User;

/**
 * Created by denis on 10.09.17.
 */
public class UserFactory {

    public static User getAdmin() {
        return new User(
                1,
                "admin@mail.com",
                "$2a$10$8IHi8NJot3CY5BDlHrivr.cVMJwtznYTNli3p7GcgwOtsF8VxgMWK",
                "Denis V",
                Role.ADMIN,
                Position.DEVELOPER
        );
    }

    public static User getUser() {
        return new User(
                2,
                "user@mail.com",
                "$2a$10$PgBb/VbejOXpdopzGU3AquVu9LDr9PhQ0fcBiGIYsVQeKB.p/paQm",
                "Dmitriy N",
                Role.USER,
                Position.DEVELOPER
        );
    }

    public static User getUser2() {
        return new User(
                3,
                "usertester@mail.com",
                "$2a$10$PgBb/VbejOXpdopzGU3AquVu9LDr9PhQ0fcBiGIYsVQeKB.p/paQm",
                "Artem B",
                Role.USER,
                Position.TESTER
        );
    }

    public static User getNewUser() {
        return new User(
                null,
                "new_user@mail.com",
                "pass",
                "New User",
                Role.USER,
                Position.TESTER
        );
    }
}
