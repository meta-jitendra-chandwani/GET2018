Select S.*,count(O.Order_Id) AS Number_Of_Order FROM User AS S INNER JOIN Orders AS O ON S.User_Id=O.User_Id WHERE O.Order_Date >= ADDDATE(curdate(),-30) GROUP BY O.User_Id ;

Select S.*,sum(O.Order_Total) AS Max_Revenue FROM User AS S INNER JOIN Orders AS O ON S.User_Id=O.User_Id GROUP BY O.User_Id ORDER BY Max_Revenue DESC LIMIT 10;

Select P.Product_Title,count(OP.Product_Id) AS Added_Most FROM Order_Product AS OP INNER JOIN Product AS P INNER JOIN Orders AS O ON OP.Product_Id=P.Product_Id && OP.Order_Id=O.Order_Id WHERE O.Order_Date >= ADDDATE(curdate(),-60) GROUP BY  P.Product_Id ORDER BY Added_Most DESC LIMIT 20;

Select Month(O.Order_Date) AS Month,sum(O.Order_Total) AS Amount FROM Orders AS O WHERE O.Order_Date >= ADDDATE(curdate(),-180) GROUP BY Month ORDER BY Month DESC;

UPDATE Product SET Status_Product="INACTIVE" WHERE Product_Id IN
(SELECT P.Product_Id FROM (Select * from Product) AS P WHERE P.Product_Id NOT IN
(SELECT DISTINCT(OP.Product_Id) FROM Order_Product OP INNER JOIN Orders O ON OP.Order_Id=O.Order_Id WHERE O.Order_Date >curdate()-90)
);

SELECT * FROM Product;