/**
Create a Stored procedure to retrieve average sales of each product in a month. Month and year will be input parameter to function.
**/

DELIMITER $$
 
CREATE PROCEDURE storedProcedure(IN Month INT,IN Year INT,OUT Tables INT)
BEGIN
    DECLARE numberOfOrder INT;
    
       SET numberOfOrder = ( SELECT count(OP.Product_Id)*Price FROM 
        Order_Product AS OP INNER JOIN Product AS P INNER JOIN Orders AS O 
        ON P.Product_Id=OP.Product_Id && O.Order_Id=OP.Order_Id
        WHERE EXTRACT(MONTH FROM Order_Date)=Month && EXTRACT(YEAR FROM Order_Date)=Year GROUP BY OP.Product_Id);
        
        SELECT numberOfOrder INTO Tables FROM 
        Order_Product AS OP INNER JOIN Product AS P INNER JOIN Orders AS O 
        ON P.Product_Id=OP.Product_Id && O.Order_Id=OP.Order_Id
        WHERE EXTRACT(MONTH FROM Order_Date)=Month && EXTRACT(YEAR FROM Order_Date)=Year GROUP BY OP.Product_Id;
        
END $$

SELECT storedProcedure(08,2018);


SELECT count(OP.Product_Id)*Price AS Total FROM 
        Order_Product AS OP INNER JOIN Product AS P INNER JOIN Orders AS O 
        ON P.Product_Id=OP.Product_Id && O.Order_Id=OP.Order_Id
        WHERE EXTRACT(MONTH FROM Order_Date)=08 && EXTRACT(YEAR FROM Order_Date)=2018 GROUP BY OP.Product_Id;
        
        SELECT AVG(numberOfOrder) INTO Tables FROM 
        Order_Product AS OP INNER JOIN Product AS P INNER JOIN Orders AS O 
        ON P.Product_Id=OP.Product_Id && O.Order_Id=OP.Order_Id
        WHERE EXTRACT(MONTH FROM Order_Date)=08 && EXTRACT(YEAR FROM Order_Date)=2018 GROUP BY OP.Product_Id;