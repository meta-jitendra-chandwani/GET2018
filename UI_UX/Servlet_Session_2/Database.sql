Drop Database Metacube_Database;
Create Database Metacube_Database;
Use Metacube_Database;
Create Table User(
First_Name VARCHAR(25),
Last_Name VARCHAR(25),
Age INT,
DOB DATE,
Mobile_Number VARCHAR(25),
Email VARCHAR(50),
Password VARCHAR(50),
Organization VARCHAR(50),
Primary Key(Email)
);
LOAD DATA LOCAL INFILE 'D:/GET2018/GET2018/UI_UX/Servlet_Session_2/UserData.txt' INTO TABLE User FIELDS TERMINATED BY '\t' LINES TERMINATED BY '\n' IGNORE 0 LINES;
Select * from User;
