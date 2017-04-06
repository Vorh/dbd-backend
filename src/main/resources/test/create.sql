
 DROP TABLE user IF EXISTS ;
CREATE TABLE user
(
  id INTEGER IDENTITY PRIMARY KEY ,
  login    VARCHAR(256),
  email    VARCHAR(256),
  password VARCHAR(256)
);

-- CREATE TABLE todo
-- (
--   id INTEGER NOT NULL,
--   caption VARCHAR(256),
--   body    VARCHAR(512),
--   user_id INTEGER,
--   PRIMARY KEY (id),
--   FOREIGN KEY (user_id) REFERENCES "user"(id)
-- );






