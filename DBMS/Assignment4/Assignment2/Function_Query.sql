
DROP FUNCTION average;
DROP PROCEDURE storedProcedure;

/**
average - calculate average of value in term of month
@return - value/30;
**/
DELIMITER $$
CREATE FUNCTION average(Value INT) RETURNS INT
 BEGIN
        RETURN (Value/30);
 END $$
 
 
/**
Create a Stored procedure to retrieve average sales of each product in a month. Month and year will be input parameter to function.

storedProcedure -  average sale of particular product in a month.
calculate average of number of product *  price from Multiple tables
Order_Product AS OP INNER JOIN Orders AS O INNER JOIN Product as P
The Join Between Order_Product and Orders - Give access of Order_Date from Order Table
The Join Between Order_product and Product -  Give access of Price from Product Table
**/
DELIMITER $$
CREATE PROCEDURE storedProcedure(IN Month INT,IN Year INT,Product_Id INT,OUT Average INT)
BEGIN
        SELECT average(count(OP.Product_Id)*Price) INTO Average FROM 
        Order_Product AS OP INNER JOIN Orders AS O INNER JOIN Product as P
        ON O.Order_Id=OP.Order_Id && P.Product_Id=OP.Product_Id
        WHERE MONTH(Order_Date)=Month && YEAR(Order_Date)=Year && OP.Product_Id=Product_Id GROUP BY OP.Product_Id;
            
END $$

CALL storedProcedure(08,2018,1003,@Average);
SELECT @Average As Average;


/**
Create a stored procedure to retrieve table having order detail with status for a given period.
Start date and end date will be input parameter. Put validation on input dates like start date is less than end date.
If start date is greater than end date take first date of month as start date.

checkStatus - retrieve table having order detail with status for a given period
Select Order Details from Order where order placed date lie between given start and end date.
**/
DROP PROCEDURE checkStatus;
DELIMITER $$
CREATE PROCEDURE checkStatus
(
IN Start_date date,
IN End_date date
)
BEGIN
        SET Start_date  = IF (Start_date > End_date ,End_date-DAY(End_date)+1,Start_date);
        Select Order_Id,User_Id,Order_Date,Status,Shipped_Date,Order_Total FROM Orders WHERE Order_Date BETWEEN Start_Date AND End_date;
END $$

CALL checkStatus('2018-08-01','2018-08-15');