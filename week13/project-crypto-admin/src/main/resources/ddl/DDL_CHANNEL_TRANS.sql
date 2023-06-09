-- DROP TABLE CHANNEL_TRANS;
CREATE TABLE IF NOT EXISTS CHANNEL_TRANS (
    ID INTEGER auto_increment PRIMARY KEY,
    CHANNEL_ID INTEGER NOT NULL,
    SOURCE VARCHAR(20) NOT NULL,
    TRAN_TYPE VARCHAR(20) NOT NULL, 
    SERVICE_VERSION VARCHAR(100) NOT NULL, 
    SERVICE_ENDPOINT VARCHAR(100) NOT NULL, 
    LAST_UPD_DATE TIMESTAMP NOT NULL DEFAULT current_timestamp,
    CONSTRAINT UC_CHANNEL_TRAN UNIQUE (SOURCE, TRAN_TYPE),
    CONSTRAINT FK_CHANNEL_TRAN FOREIGN KEY (CHANNEL_ID) REFERENCES CHANNELS(ID)
);