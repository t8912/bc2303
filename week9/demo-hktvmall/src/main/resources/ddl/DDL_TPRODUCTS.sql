CREATE TABLE TPRODUCTS (
  CREATED_DATE DATETIME NOT NULL,
  ID MEDIUMINT AUTO_INCREMENT,
  PRODUCT_NAME VARCHAR(50) NOT NULL,
  UNIT_PRICE NUMERIC(10,2) NOT NULL,
  QUANTITY NUMERIC(10) NOT NULL,
  STATUS VARCHAR(1) NOT NULL,
  CONSTRAINT PK_TPRODUCT PRIMARY KEY(ID)
);