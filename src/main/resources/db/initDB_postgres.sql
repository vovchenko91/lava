DROP TABLE IF EXISTS comments;
DROP TABLE IF EXISTS tasks;
DROP TABLE IF EXISTS projects;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id          SERIAL PRIMARY KEY,
  email       TEXT NOT NULL UNIQUE,
  password    TEXT NOT NULL,
  name        TEXT NOT NULL,
  role        INTEGER NOT NULL,
  position    INTEGER NOT NULL
);

CREATE TABLE projects (
  id          SERIAL PRIMARY KEY,
  name        TEXT NOT NULL
);

CREATE TABLE tasks (
  id          SERIAL PRIMARY KEY,
  project_id  INTEGER NOT NULL,
  name        TEXT NOT NULL,
  type        INTEGER NOT NULL,
  status      INTEGER NOT NULL,
  priority    INTEGER NOT NULL,
  description TEXT,
  assignee_id INTEGER NOT NULL,
  reporter_id INTEGER NOT NULL,
  FOREIGN KEY (project_id) REFERENCES projects (id) ON DELETE SET NULL,
  FOREIGN KEY (assignee_id) REFERENCES users (id) ON DELETE SET NULL,
  FOREIGN KEY (reporter_id) REFERENCES users (id) ON DELETE SET NULL
);

CREATE TABLE comments (
  id          SERIAL PRIMARY KEY,
  task_id     INTEGER NOT NULL,
  author      TEXT NOT NULL,
  datetime    TIMESTAMP WITH TIME ZONE NOT NULL,
  text        TEXT,
  FOREIGN KEY (task_id) REFERENCES tasks (id) ON DELETE CASCADE
);
