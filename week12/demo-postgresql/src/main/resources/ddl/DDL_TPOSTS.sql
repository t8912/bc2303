CREATE TABLE TPOSTS (
  ID serial,
  USER_ID INT NOT NULL,
  POST_TITLE VARCHAR(100),
  POST_BODY VARCHAR(100),
  CONSTRAINT PK_TPOST PRIMARY KEY(ID),
  CONSTRAINT FK_TPOST FOREIGN KEY(USER_ID) REFERENCES TUSERS(ID)
);