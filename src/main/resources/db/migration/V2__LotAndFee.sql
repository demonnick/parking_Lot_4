-- CREATE TABLE LOT (
--   ID INTEGER IDENTITY PRIMARY KEY,
--  FEE_ID INTEGER
-- );
--
-- INSERT INTO LOT (ID,FEE_STRUCTURE_ID) VALUES (1,1);
--
--



CREATE TABLE FEE_STRUCTURE(

LOT_ID INTEGER,
TIME_INFO VARCHAR(256),
PRICE INT,
START_TIME INT,
END_TIME INT,
FEE_ID INT

);

INSERT INTO FEE_STRUCTURE (LOT_ID, TIME_INFO, PRICE, START_TIME, END_TIME,  FEE_ID ) VALUES (1,'to 1 hour',10,0,60,1);
INSERT INTO FEE_STRUCTURE (LOT_ID, TIME_INFO, PRICE, START_TIME, END_TIME,  FEE_ID ) VALUES (1,'to 2 hours',20,61,120,2);
INSERT INTO FEE_STRUCTURE (LOT_ID, TIME_INFO, PRICE, START_TIME, END_TIME,  FEE_ID ) VALUES (1,'to 3 hours',50,121,180,3);
INSERT INTO FEE_STRUCTURE (LOT_ID, TIME_INFO, PRICE, START_TIME, END_TIME,  FEE_ID ) VALUES (1,'to 5 hours',60,181,240,4);
INSERT INTO FEE_STRUCTURE (LOT_ID, TIME_INFO, PRICE, START_TIME, END_TIME,  FEE_ID ) VALUES (1,'to 7 hours',75,241,300,5);
