/**
Display Shopper’s information along with number of orders he/she placed during last 30 days.
**/
Select 
    S.*, count(O.Order_Id) AS Number_Of_Order
FROM
    User AS S
        INNER JOIN
    Orders AS O ON S.User_Id = O.User_Id
WHERE
    O.Order_Date >= ADDDATE(curdate(), -30)
GROUP BY O.User_Id ;

/**
Display the top 10 Shoppers who generated maximum number of revenue in last 30 days.
**/
Select 
    S.*, sum(O.Order_Total) AS Max_Revenue
FROM
    User AS S
        INNER JOIN
    Orders AS O ON S.User_Id = O.User_Id
GROUP BY O.User_Id
ORDER BY Max_Revenue DESC
LIMIT 10;

/**
Display top 20 Products which are ordered most in last 60 days along with numbers.
**/
Select 
    P.Product_Title, count(OP.Product_Id) AS Added_Most
FROM
    Order_Product AS OP
        INNER JOIN
    Product AS P
        INNER JOIN
    Orders AS O ON OP.Product_Id = P.Product_Id && OP.Order_Id = O.Order_Id
WHERE
    O.Order_Date >= ADDDATE(curdate(), -60)
GROUP BY P.Product_Id
ORDER BY Added_Most DESC
LIMIT 20;

/**
Display Monthly sales revenue of the StoreFront for last 6 months. It should display each month’s sale.
**/
Select 
    Month(O.Order_Date) AS Month, sum(O.Order_Total) AS Amount
FROM
    Orders AS O
WHERE
    O.Order_Date >= ADDDATE(curdate(), -180)
GROUP BY Month
ORDER BY Month DESC;

/**
Mark the products as Inactive which are not ordered in last 90 days.
**/
SET SQL_SAFE_UPDATES = 0;
UPDATE Product SET Status_Product="INACTIVE" WHERE Product_Id IN
(SELECT P.Product_Id FROM (Select * from Product) AS P WHERE P.Product_Id NOT IN
(SELECT DISTINCT(OP.Product_Id) FROM Order_Product OP INNER JOIN Orders O ON OP.Order_Id=O.Order_Id WHERE O.Order_Date >curdate()-90)
);

SELECT 
    *
FROM
    Product;
    
/**
Given a category search keyword, display all the Products present in this category/categories. 
**/
SELECT 
    P.Product_Title, C.Category_Title
FROM
    Product AS P
        INNER JOIN
    Category AS C ON C.Category_Id = P.Category_Id
WHERE
    Category_Title LIKE '%Jean%' ;

/**
Display top 10 Items which were cancelled most.
**/
SELECT 
    P.Product_Title, T.Product_Id
FROM
    (SELECT 
        OP.Product_Id, O.Status
    FROM
        Order_Product AS OP
    INNER JOIN Orders AS O
    WHERE
        O.Status LIKE '%Cancelled%') AS T
        LEFT JOIN
    PRODUCT AS P ON P.Product_Id = T.Product_Id
GROUP BY T.Product_Id;

/**
Delete all those products which were not ordered by any Shopper in last 1 year. Return the number of products deleted.
**/

SET SQL_SAFE_UPDATES = 0;
UPDATE Product SET Status_Product='INACTIVE' WHERE Product_Id IN
(SELECT P.Product_Id FROM (Select * from Product) AS P WHERE P.Product_Id NOT IN
(SELECT DISTINCT(OP.Product_Id) FROM Order_Product OP INNER JOIN Orders O ON OP.Order_Id=O.Order_Id WHERE O.Order_Date >curdate()-365)
);
Select * from Product;
Select Parent_Category from Category;


SELECT C.Category_Title, Count(C1.Category_Id) AS count_Of_Child 
FROM Category AS C
LEFT JOIN category  AS C1 
ON C.Category_Title=C1.Parent_Category
WHERE c.Parent_Category like 'Top%'
GROUP BY C.Category_Title
ORDER BY C.Category_Title;
