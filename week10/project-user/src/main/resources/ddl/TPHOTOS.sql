CREATE TABLE TPHOTOS (
  id INT PRIMARY KEY,
  albumId INT NOT NULL,
  title VARCHAR(255) NOT NULL,
  url VARCHAR(255) NOT NULL,
  thumbnailUrl VARCHAR(255) NOT NULL,
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  FOREIGN KEY (albumId) REFERENCES TALBUMS(id)
);