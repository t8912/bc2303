-- DROP TABLE CHANNELS;
CREATE TABLE IF NOT EXISTS CHANNELS (
          ID INTEGER auto_increment PRIMARY KEY,
          CHANNEL_CODE VARCHAR(50) NOT NULL,
          CHANNEL_DOMAIN VARCHAR(100) NOT NULL,
          LAST_UPD_DATE TIMESTAMP NOT NULL DEFAULT current_timestamp,
          CONSTRAINT UC_CHANNEL UNIQUE (CHANNEL_CODE)
);