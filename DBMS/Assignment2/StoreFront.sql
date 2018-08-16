DROP DATABASE StoreFront;
CREATE DATABASE StoreFront;
USE StoreFront;

CREATE TABLE Category(
    Category_Id INT NOT NULL AUTO_INCREMENT,
    Category_Title VARCHAR(20),
    Parent_Category VARCHAR(30),
    PRIMARY KEY (Category_Id)
);
LOAD DATA LOCAL INFILE 'D:/GET2018/GET2018/DBMS/Assignment2/Assignment2/Category.txt' INTO TABLE Category FIELDS TERMINATED BY '\t' LINES TERMINATED BY '\n' IGNORE 0 LINES (Category_Title,Parent_Category);
SELECT * FROM Category;


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
/*
LOAD DATA LOCAL INFILE "D:\GET2018\GET2018\DBMS\Assignment2\Assignment2\Category.txt" INTO TABLE Category;

INSERT INTO Product(Product_Id,Product_Title,Category_Id,Description,Price,Quantity) 
VALUES(1002,"JBL C100SI EarPhones",1,"JBL C100SI is one of the best earphone in this price",799,10),
(1003,"JBL C200SI EarPhones",1,"JBL C200SI is one of the best earphone in this price",899,10),
(1004,"JBL C300SI EarPhones",1,"JBL C300SI is one of the best HeadPhones in this price",1299,5),
(1005,"Segate 2 TB HDD",2,"Seagte HDD",3965,5),
(1006,"Mi Power Bank",3,"Mi Power Bank 10000mAH",990,5);

SELECT 
    P.Product_Id,
    P.Product_Title,
    P.Category_Id,
    P.Description,
    P.Price,
    P.Quantity
FROM
    Product as P INNER JOIN Category as C
ON
    P.Category_Id = C.Category_Id;


SELECT * FROM Category;
CREATE TABLE Image(
    Image_Id INT NOT NULL,
    Image_Name VARCHAR(30),
    Product_Id INT,
    Image_URL VARCHAR(30),
    PRIMARY KEY (Image_Id),
    FOREIGN KEY (Product_Id)
        REFERENCES Product (Product_Id)
); 
*/
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

