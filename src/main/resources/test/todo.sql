DROP TABLE todo IF EXISTS ;
CREATE TABLE todo
(
  id INTEGER IDENTITY PRIMARY KEY ,
  caption VARCHAR(256),
  content    VARCHAR(512),
  user_id INTEGER,
  date TIMESTAMP,
  type INTEGER,
  complete BOOLEAN DEFAULT FALSE ,
  FOREIGN KEY (user_id) REFERENCES users(id)
);

