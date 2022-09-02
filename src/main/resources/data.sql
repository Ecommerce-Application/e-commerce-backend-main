
DROP TABLE IF EXISTS dummytable;
CREATE TABLE dummytable;

--DROP TABLE IF EXISTS Product; --Sometimes Hibernate doesn't actually drop its tables upon termination
--CREATE TABLE IF NOT EXISTS Product (
--	prodId SERIAL,
--	prodQuantity INT,
--	prodPrice NUMERIC (15,6),
--	prodDesc VARCHAR(200),
--	prodImage VARCHAR(200),
--	prodName VARCHAR (50));
--
--INSERT INTO Product VALUES (
--	DEFAULT,
--	10,
--	20.50,
--	'someDesc',
--	'someImageURI',
--	'someName');
--
