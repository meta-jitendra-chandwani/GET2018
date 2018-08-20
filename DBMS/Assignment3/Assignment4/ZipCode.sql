/**
Create appropriate tables and relationships for the same and write a SQL
query for that returns a Resultset containing Zip Code, City Names and
States ordered by State Name and City Name.

Create Table and show table data in Order by State name and City Name
**/

DROP Table Zip_Code;
CREATE TABLE Zip_Code(
    ZipCode INT NOT NULL,
    City VARCHAR(30),
    State VARCHAR(30),
    PRIMARY KEY(ZipCode)
);
LOAD DATA LOCAL INFILE 'D:/GET2018/GET2018/DBMS/Assignment2/Assignment2/ZipCode.txt' INTO TABLE Zip_Code  FIELDS TERMINATED BY '\t' LINES TERMINATED BY '\n' IGNORE 0 LINES;
Select * from Zip_Code ORDER BY State,City;