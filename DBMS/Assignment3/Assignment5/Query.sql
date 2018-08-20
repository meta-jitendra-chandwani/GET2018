/**
Create a view displaying the order information
(Id, Title, Price, Shopper’s name, Email, Orderdate, Status) 
with latest ordered items should be displayed first for last 60 days.
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
**/
SELECT 
    Product_Title
FROM
    Order_Details
WHERE
    Status = 'Shipped';

/**
Use the above view to display the top 5 most selling products.
**/
SELECT 
    Product_Title
FROM
    Order_Details
GROUP BY Product_Title
ORDER BY count(Product_Title) DESC
LIMIT 5;