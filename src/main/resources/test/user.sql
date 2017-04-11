
DROP TABLE users IF EXISTS CASCADE ;
CREATE TABLE users
(
  id INTEGER IDENTITY PRIMARY KEY ,
  login    VARCHAR(256),
  email    VARCHAR(256),
  password VARCHAR(256)
);

 INSERT INTO users (id, login, email, password) VALUES (1,'BY_ID','TEST@MAIL.RU','123456');








