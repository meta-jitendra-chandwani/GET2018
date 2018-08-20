/**
Create a function to calculate number of orders in a month. Month and year will be input parameter to function.
**/

DELIMITER $$
 
CREATE FUNCTION getNumberOfOrder(Month INT,Year INT) RETURNS INT
    DETERMINISTIC
BEGIN
    DECLARE numberOfOrder INT;
    SET numberOfOrder = (SELECT count(Order_Id) FROM Orders WHERE Month = MONTH(Order_Date) AND Year = YEAR(Order_Date));
    RETURN numberOfOrder;
 
END $$

SELECT getNumberOfOrder(08,2018);

/**
Create a function to return month in a year having maximum orders. Year will be input parameter.
**/

DELIMITER $$
 
CREATE FUNCTION getMonthWithMaximumOrder(Year INT) RETURNS INT
    DETERMINISTIC
BEGIN
    DECLARE maximumOrdersMonth INT;
    SET maximumOrdersMonth = (SELECT MONTH(Order_Date) AS Month FROM Orders WHERE YEAR(Order_Date)=Year GROUP BY Month DESC LIMIT 1);
    RETURN maximumOrdersMonth;
 
END $$

SELECT getMonthWithMaximumOrder(2017);