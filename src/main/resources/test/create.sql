
 DROP TABLE users IF EXISTS ;
CREATE TABLE users
(
  id INTEGER IDENTITY PRIMARY KEY ,
  login    VARCHAR(256),
  email    VARCHAR(256),
  password VARCHAR(256)
);

 INSERT INTO users (id, login, email, password) VALUES (1,'BY_ID','TEST@MAIL.RU','123456');

-- CREATE TABLE todo
-- (
--   id INTEGER NOT NULL,
--   caption VARCHAR(256),
--   body    VARCHAR(512),
--   user_id INTEGER,
--   PRIMARY KEY (id),
--   FOREIGN KEY (user_id) REFERENCES "user"(id)
-- );






