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
Image longblob NULL,
Primary Key(Email)
);
select * from Metacube_Database.User;

Select * from Employee.EmployeeDetails
Update Metacube_Database.User SET Age = 80 where Email='jchandwani27896@gmail.com';