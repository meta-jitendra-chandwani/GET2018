SELECT Order_Id, Order_Date, Order_Total FROM Orders WHERE (SELECT DATEDIFF(curdate(), Order_Date) AS Diff) >= 1;

SELECT Order_Id, Order_Date, Order_Total FROM Orders ORDER BY Order_Total DESC LIMIT 10; 

SELECT Order_Id, Order_Date, Order_Total FROM Orders WHERE (SELECT DATEDIFF(curdate(), Order_Date) AS Diff) > 10 && Status != 'Shipped';

SELECT * FROM User WHERE User_Type="Shopper" && (SELECT DATEDIFF(curdate(), Last_Order) AS Diff) > 30;

SELECT U.User_Name,O.Order_Id FROM Orders as O INNER JOIN  User AS U ON O.User_Id=U.User_Id WHERE (SELECT DATEDIFF(curdate(), U.Last_Order) AS Diff) >= 15;

SELECT P.Product_Title FROM Order_Product AS OP INNER JOIN Product AS P INNER JOIN Orders as O ON OP.Product_Id=P.Product_Id && OP.Order_Id=O.Order_Id WHERE O.Status="Shipped"  && O.Order_Id like "Order08/1";

SELECT P.Product_Title,O.Order_Date FROM Order_Product AS OP INNER JOIN Product AS P INNER JOIN Orders as O ON OP.Product_Id=P.Product_Id && OP.Order_Id=O.Order_Id WHERE P.Price > 1000 && P.Price < 2000;

UPDATE Orders AS O SET O.Status="Shipper" WHERE O.Order_Date=curdate() limit 20;
SELECT * FROM Orders;