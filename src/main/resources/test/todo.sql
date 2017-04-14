DROP TABLE todo IF EXISTS ;
CREATE TABLE todo
(
  id INTEGER IDENTITY PRIMARY KEY ,
  caption VARCHAR(256),
  body    VARCHAR(512),
  user_id INTEGER,
  FOREIGN KEY (user_id) REFERENCES users(id)
);

