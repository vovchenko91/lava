DELETE FROM comments;
ALTER SEQUENCE comments_id_seq RESTART WITH 1;
DELETE FROM tasks;
ALTER SEQUENCE tasks_id_seq RESTART WITH 1;
DELETE FROM projects;
ALTER SEQUENCE projects_id_seq RESTART WITH 1;
DELETE FROM users;
ALTER SEQUENCE users_id_seq RESTART WITH 1;

INSERT INTO users (email, password, name, role, position)
VALUES ('admin@mail.com', '$2a$10$8IHi8NJot3CY5BDlHrivr.cVMJwtznYTNli3p7GcgwOtsF8VxgMWK', 'Administrator', 0, 0);
INSERT INTO users (email, password, name, role, position)
VALUES ('user@mail.com', '$2a$10$PgBb/VbejOXpdopzGU3AquVu9LDr9PhQ0fcBiGIYsVQeKB.p/paQm', 'Developer', 1, 0);
INSERT INTO users (email, password, name, role, position)
VALUES ('usertester@mail.com', '$2a$10$PgBb/VbejOXpdopzGU3AquVu9LDr9PhQ0fcBiGIYsVQeKB.p/paQm', 'Tester', 1, 1);

INSERT INTO projects (name)
VALUES ('Web Project');
INSERT INTO projects (name)
VALUES ('Back-End Project');

INSERT INTO tasks (project_id, name, type, status, priority, description, assignee_id)
VALUES (1, 'First task', 1, 1, 1, 'some description', 1);
INSERT INTO tasks (project_id, name, type, status, priority, description, assignee_id)
VALUES (1, 'Second task', 1, 1, 1, 'some description', 1);
INSERT INTO tasks (project_id, name, type, status, priority, description, assignee_id)
VALUES (1, 'Third task', 1, 1, 1, 'some description', 1);

INSERT INTO comments (task_id, author, datetime, text)
VALUES (1, 'Сергей', '2016-12-28 13:00:00', 'Отличный девайс. Пользуюсь уже около года. Никаких замечаний');
INSERT INTO comments (task_id, author, datetime, text)
VALUES (2, 'Анна', '2017-03-12 15:00:00', 'Возникли проблемы на второй месяц использования. Пропадает зук в динамиках');
INSERT INTO comments (task_id, author, datetime, text)
VALUES (1, 'Инна', '2017-04-05 10:30:00', 'Хоший телефон. Единственный недостаток это цена :(');