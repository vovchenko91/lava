DELETE FROM comments;
ALTER SEQUENCE comments_id_seq RESTART WITH 1;
DELETE FROM tasks;
ALTER SEQUENCE tasks_id_seq RESTART WITH 1;
DELETE FROM projects;
ALTER SEQUENCE projects_id_seq RESTART WITH 1;
DELETE FROM users;
ALTER SEQUENCE users_id_seq RESTART WITH 1;

INSERT INTO users (email, password, name, role, position)
VALUES ('admin@mail.com', '$2a$10$8IHi8NJot3CY5BDlHrivr.cVMJwtznYTNli3p7GcgwOtsF8VxgMWK', 'Denis V', 0, 0);
INSERT INTO users (email, password, name, role, position)
VALUES ('user@mail.com', '$2a$10$PgBb/VbejOXpdopzGU3AquVu9LDr9PhQ0fcBiGIYsVQeKB.p/paQm', 'Dmitriy N', 1, 0);
INSERT INTO users (email, password, name, role, position)
VALUES ('usertester@mail.com', '$2a$10$PgBb/VbejOXpdopzGU3AquVu9LDr9PhQ0fcBiGIYsVQeKB.p/paQm', 'Artem B', 1, 1);

INSERT INTO projects (name)
VALUES ('Front-End Project');
INSERT INTO projects (name)
VALUES ('Back-End Project');

INSERT INTO tasks (project_id, name, type, status, priority, description, assignee_id, reporter_id)
VALUES (1, 'BR File upload: if first choose is Any - Add condition activated', 1, 0, 1, 'steps: 1,2,3', 1, 2);
INSERT INTO tasks (project_id, name, type, status, priority, description, assignee_id, reporter_id)
VALUES (1, 'BR Visited webpage: condition Webpage URL and Time Idle/Active do not work in conjunction', 1, 0, 1, 'steps: 1,2,3,4', 2, 1);
INSERT INTO tasks (project_id, name, type, status, priority, description, assignee_id, reporter_id)
VALUES (1, 'Uploaded Big files via OneDrive (office365) do not appear in File transfers report', 1, 0, 1, 'steps: 1,2', 2, 1);

INSERT INTO comments (task_id, author_id, datetime, text)
VALUES (1, 1, '2016-12-28 13:00:00', 'Нужно проверить на Windows Server');
INSERT INTO comments (task_id, author_id, datetime, text)
VALUES (2, 1, '2017-03-12 15:00:00', 'Не получается воспроизвести');
INSERT INTO comments (task_id, author_id, datetime, text)
VALUES (1, 2, '2017-04-05 10:30:00', 'Что-то не так с этой задачей');