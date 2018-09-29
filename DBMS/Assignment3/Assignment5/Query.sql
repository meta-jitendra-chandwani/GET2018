/**
Create a view displaying the order information
(Id, Title, Price, Shopper’s name, Email, Orderdate, Status) 
with latest ordered items should be displayed first for last 60 days.

Create View of Order_Details - Select All the order details from multiple tables
Order_Product AS OP INNER JOIN ORDERS AS O  INNER JOIN Product AS P  INNER JOIN User AS U
The Join Between Order_Product and Order - Access to Order Date and Status
The Join Between Order_Product and Product - Access to Product title and Price
The Join Between User and Product - Accesss the User Name

Select Data of order item for last 60 days
**/

CREATE VIEW Order_Details
AS SELECT 
    P.Product_Id,
    P.Product_Title,
    P.Price,
    U.User_Name,
    O.Order_Date,
    O.Status
FROM
    Order_Product AS OP
        INNER JOIN
    ORDERS AS O
        INNER JOIN
    Product AS P
        INNER JOIN
    User AS U ON OP.Order_Id = O.Order_Id && P.Product_Id = OP.Product_Id && U.User_Id = O.User_Id
WHERE
    O.Order_Date > ADDDATE(curdate(), -60)
ORDER BY Order_Date DESC;

/**
Use the above view to display the Products(Items) which are in ‘shipped’ state.

Select Product title from View
**/
SELECT 
    Product_Title
FROM
    Order_Details
WHERE
    Status = 'Shipped';

/**
Use the above view to display the top 5 most selling products.
Select Product Title from View according to 5 most selling product.
**/
SELECT 
    Product_Title
FROM
    Order_Details
GROUP BY Product_Title
ORDER BY count(Product_Title) DESC
LIMIT 5;