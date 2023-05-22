CREATE TABLE TSHOPPING_CARTS (
  ITEM_ID VARCHAR(32),
  CREATED_DATETIME DATETIME NOT NULL,
  USER_ID VARCHAR(10) NOT NULL,
  PRODUCT_ID MEDIUMINT NOT NULL,
  UNIT_PRICE NUMERIC(10,2) NOT NULL,
  PRODUCT_QUANTITY NUMERIC(6) NOT NULL,
  STATUS VARCHAR(1) NOT NULL,
  CONSTRAINT PK_TSHOPPING_CART PRIMARY KEY(ITEM_ID),
  CONSTRAINT FK_TSHOPPING_CART1 FOREIGN KEY(USER_ID) REFERENCES TUSERS(USER_ID),
  CONSTRAINT FK_TSHOPPING_CART2 FOREIGN KEY(PRODUCT_ID) REFERENCES TPRODUCTS(ID)
);