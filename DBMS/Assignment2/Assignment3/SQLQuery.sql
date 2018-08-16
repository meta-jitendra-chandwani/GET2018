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
    Last_Order Date,
    PRIMARY KEY (User_Id)
);
LOAD DATA LOCAL INFILE 'D:/GET2018/GET2018/DBMS/Assignment2/Assignment2/UserType.txt' INTO TABLE User FIELDS TERMINATED BY '\t' LINES TERMINATED BY '\n' IGNORE 0 LINES;
SELECT * from User;
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
    Shipped_Date date,
    Order_Total INT,
    FOREIGN KEY (User_Id)
        REFERENCES User (User_Id),
    PRIMARY KEY(Order_Id)
);
LOAD DATA LOCAL INFILE 'D:/GET2018/GET2018/DBMS/Assignment2/Assignment2/Orders.txt' INTO TABLE Orders  FIELDS TERMINATED BY '\t' LINES TERMINATED BY '\n' IGNORE 0 LINES;

CREATE TABLE Order_Product(
    Order_Product_Id INT NOT NULL AUTO_INCREMENT,
    Order_Id VARCHAR(20),
    Product_Id INT,
    FOREIGN KEY (Order_Id)
        REFERENCES Orders (Order_Id),
    FOREIGN KEY (Product_Id)
        REFERENCES Product (Product_Id),
    PRIMARY KEY(Order_Product_Id)
);
LOAD DATA LOCAL INFILE 'D:/GET2018/GET2018/DBMS/Assignment2/Assignment2/OrderProduct.txt' INTO TABLE Order_Product  FIELDS TERMINATED BY '\t' LINES TERMINATED BY '\n' IGNORE 0 LINES (Order_Id,Product_Id);

SELECT Order_Id, Order_Date, Order_Total FROM Orders;
SELECT Order_Id, Order_Date, Order_Total FROM Orders ORDER BY Order_Total DESC LIMIT 10; 
SELECT Order_Id, Order_Date, Order_Total FROM Orders WHERE (SELECT DATEDIFF(curdate(), Order_Date) AS Diff) > 10 && Status != 'Shipped';
SELECT * FROM User WHERE User_Type="Shopper" && (SELECT DATEDIFF(curdate(), Last_Order) AS Diff) > 30;
SELECT U.User_Name,O.Order_Id FROM Orders as O INNER JOIN  User AS U ON O.User_Id=U.User_Id WHERE (SELECT DATEDIFF(curdate(), U.Last_Order) AS Diff) >= 15;
SELECT P.Product_Title FROM Order_Product AS OP INNER JOIN Product AS P INNER JOIN Orders as O ON OP.Product_Id=P.Product_Id && OP.Order_Id=O.Order_Id WHERE O.Status="Shipped"  && O.Order_Id="Order012/8/18";
SELECT P.Product_Title,O.Order_Date FROM Order_Product AS OP INNER JOIN Product AS P INNER JOIN Orders as O ON OP.Product_Id=P.Product_Id && OP.Order_Id=O.Order_Id WHERE P.Price > 1000 && P.Price < 2000;
UPDATE Orders AS O SET O.Status="Shipper" WHERE O.Order_Date=curdate() limit 20;
SELECT * FROM Orders;