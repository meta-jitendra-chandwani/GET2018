DROP DATABASE StoreFront;
CREATE DATABASE StoreFront;
USE StoreFront;

CREATE TABLE Category(
    Category_Id INT NOT NULL AUTO_INCREMENT,
    Category_Title VARCHAR(20),
    Parent_Category VARCHAR(30),
    PRIMARY KEY (Category_Id)
);

CREATE TABLE Product(
    Product_Id INT NOT NULL,
    Product_Title VARCHAR(30),
    Category_Id INT,
    Description VARCHAR(200),
    Price INT,
    Quantity INT,
    FOREIGN KEY (Category_Id)
        REFERENCES Category (Category_Id),
    PRIMARY KEY (Product_Id)
);

CREATE TABLE Image(
    Image_Id INT NOT NULL,
    Image_Name VARCHAR(30),
    Product_Id INT,
    Image_URL VARCHAR(30),
    PRIMARY KEY (Image_Id),
    FOREIGN KEY (Product_Id)
        REFERENCES Product (Product_Id)
); 

CREATE TABLE User(
    User_Id INT NOT NULL,
    User_Type VARCHAR(25),
    PRIMARY KEY (User_Id)
);

CREATE TABLE Administrator(
    User_Id INT,
    User_Name VARCHAR(25),
    FOREIGN KEY (User_Id)
        REFERENCES User (User_Id)
);

CREATE TABLE Shopper(
    User_Id INT,
    User_Name VARCHAR(25),
    Mobile_Number INT,
    FOREIGN KEY (User_Id)
        REFERENCES User (User_Id)
);

CREATE TABLE Address(
    Address_Id INT NOT NULL,
    User_Id Int,
    Flat_Number Int,
    Street VARCHAR(100),
    District VARCHAR(30),
    State VARCHAR(30),
    Country VARCHAR(30),
    FOREIGN KEY (User_Id)
        REFERENCES User (User_Id),
    PRIMARY KEY (Address_Id)
);

CREATE TABLE Orders(
    Order_Id INT NOT NULL,
    Order_Date date,
    Status VARCHAR(20),
    Order_Total INT,
    User_Id INT,
    FOREIGN KEY (User_Id)
        REFERENCES User (User_Id)
);
DROP Table Image;
DROP TABLE Product;

SHOW tables;

CREATE TABLE Product(
    Product_Id INT NOT NULL,
    Product_Title VARCHAR(30),
    Category_Id INT,
    Description VARCHAR(200),
    Price INT,
    Quantity INT,
    FOREIGN KEY (Category_Id)
        REFERENCES Category (Category_Id),
    PRIMARY KEY (Product_Id)
);
CREATE TABLE Image(
    Image_Id INT NOT NULL,
    Image_Name VARCHAR(30),
    Product_Id INT,
    Image_URL VARCHAR(30),
    PRIMARY KEY (Image_Id),
    FOREIGN KEY (Product_Id)
        REFERENCES Product (Product_Id)
); 

SHOW tables;