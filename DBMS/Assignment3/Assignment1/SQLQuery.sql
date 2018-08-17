SELECT COUNT(*) FROM Product WHERE Price < 1000 && Price > 0;
SELECT COUNT(*) FROM Product WHERE Price < 5000 && Price > 1001;
SELECT COUNT(*) FROM Product WHERE Price > 5001;

Select C.Category_Title,count(P.Product_Id) AS Number_Of_Product FROM Product AS P INNER JOIN Category AS C ON P.Category_Id=C.Category_Id GROUP BY P.Category_Id;
