CREATE TABLE TUSERS (
  id INT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  username VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  address_street VARCHAR(255) NOT NULL,
  address_suite VARCHAR(255),
  address_city VARCHAR(255) NOT NULL,
  address_zipcode VARCHAR(255) NOT NULL,
  address_geo_lat FLOAT NOT NULL,
  address_geo_lng FLOAT NOT NULL,
  phone VARCHAR(255) NOT NULL,
  website VARCHAR(255) NOT NULL,
  company_name VARCHAR(255) NOT NULL,
  company_catchPhrase VARCHAR(255) NOT NULL,
  company_bs VARCHAR(255) NOT NULL
);