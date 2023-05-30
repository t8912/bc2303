CREATE TABLE TINVOICES (
  INVOICE_ID VARCHAR(10),
  ITEM_ID VARCHAR(32),
  CREATED_DATETIME DATETIME NOT NULL,
  USER_ID VARCHAR(10) NOT NULL,
  PRODUCT_ID MEDIUMINT NOT NULL,
  UNIT_PRICE NUMERIC(10,2) NOT NULL,
  PRODUCT_QUANTITY NUMERIC(6) NOT NULL,
  CONSTRAINT PK_TINVOICE PRIMARY KEY(INVOICE_ID),
  CONSTRAINT FK_TINVOICE1 FOREIGN KEY(USER_ID) REFERENCES TUSERS(USER_ID),
  CONSTRAINT FK_TINVOICE2 FOREIGN KEY(PRODUCT_ID) REFERENCES TPRODUCTS(ID),
  CONSTRAINT FK_TINVOICE3 FOREIGN KEY(ITEM_ID) REFERENCES TSHOPPING_CARTS(ITEM_ID)
);