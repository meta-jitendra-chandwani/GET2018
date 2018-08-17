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

LOAD DATA LOCAL INFILE 'D:/GET2018/GET2018/DBMS/Assignment2/Assignment2/Product.txt' INTO TABLE Product FIELDS TERMINATED BY '\t' LINES TERMINATED BY '\n' IGNORE 0 LINES;

CREATE TABLE Image(
    Image_Id INT NOT NULL,
    Image_URL VARCHAR(30),
    Product_Id INT,    
    PRIMARY KEY (Image_Id),
    FOREIGN KEY (Product_Id)
        REFERENCES Product (Product_Id)
); 
LOAD DATA LOCAL INFILE 'D:/GET2018/GET2018/DBMS/Assignment2/Assignment2/Image.txt' INTO TABLE Image FIELDS TERMINATED BY '\t' LINES TERMINATED BY '\n' IGNORE 0 LINES;

CREATE TABLE User(
    User_Id VARCHAR(20) NOT NULL,
    User_Type VARCHAR(25),
    User_Name VARCHAR(25),
    Mobile_Number INT,
    PRIMARY KEY (User_Id)
);
LOAD DATA LOCAL INFILE 'D:/GET2018/GET2018/DBMS/Assignment2/Assignment2/UserType.txt' INTO TABLE User FIELDS TERMINATED BY '\t' LINES TERMINATED BY '\n' IGNORE 0 LINES;

CREATE TABLE Address(
    Address_Id INT NOT NULL AUTO_INCREMENT,
    User_Id Varchar(20),
    Flat_Number Int,
    Street VARCHAR(100),
    District VARCHAR(30),
    State VARCHAR(30),
    Country VARCHAR(30),
    FOREIGN KEY (User_Id)
        REFERENCES User (User_Id),
    PRIMARY KEY (Address_Id)
);
LOAD DATA LOCAL INFILE 'D:/GET2018/GET2018/DBMS/Assignment2/Assignment2/Address.txt' INTO TABLE Address  FIELDS TERMINATED BY '\t' LINES TERMINATED BY '\n' IGNORE 0 LINES (User_Id,Flat_Number,Street,District,State,Country);

CREATE TABLE Orders(
    Order_Id VARCHAR(20) NOT NULL,
    User_Id VARCHAR(20),
    Order_Date date,
    Status VARCHAR(20),
    Order_Total INT,
    FOREIGN KEY (User_Id)
        REFERENCES User (User_Id)
);
LOAD DATA LOCAL INFILE 'D:/GET2018/GET2018/DBMS/Assignment2/Assignment2/Orders.txt' INTO TABLE Orders  FIELDS TERMINATED BY '\t' LINES TERMINATED BY '\n' IGNORE 0 LINES;

SELECT P.Product_Id,C.Category_Title,P.Price FROM Product AS P INNER JOIN Category AS C ON P.Category_Id=C.Category_Id WHERE P.Quantity>0;

SELECT Product_Title FROM Product AS P INNER JOIN Image AS I ON I.Product_Id=P.Product_Id WHERE I.Image_URL="";

SELECT * FROM Category ORDER BY Parent_Category ASC,Category_Title ASC;

SELECT * FROM Category WHERE  Parent_Category NOT LIKE "Top%";

SELECT P.Product_Title,P.Price,P.Description FROM Product AS P INNER JOIN Category AS C ON P.Category_Id=C.Category_Id WHERE C.Category_Title="Head Phones";

SELECT Product_Title FROM Product WHERE Quantity<50;

UPDATE Product SET Quantity=Quantity+100 WHERE Product_Id>1000;
SELECT * From Product;