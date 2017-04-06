CREATE TABLE todo
(
  id PRIMARY KEY NOT NULL,
  caption VARCHAR(256),
  body    VARCHAR(512),
  user_id INTEGER
);

CREATE UNIQUE INDEX todo_id_uindex
  ON todo (id);

CREATE UNIQUE INDEX todo_user_id_uindex
  ON todo (user_id);

CREATE TABLE "user"
(
  id PRIMARY KEY NOT NULL,
  login    VARCHAR(256),
  email    VARCHAR(256),
  password VARCHAR(256)
);

CREATE UNIQUE INDEX user_id_uindex
  ON "user" (id);

ALTER TABLE todo
  ADD CONSTRAINT todo_user_id_fk
FOREIGN KEY (user_id) REFERENCES user (id);

