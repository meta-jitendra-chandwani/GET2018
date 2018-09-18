SELECT P.Product_Id,C.Category_Title,P.Price FROM Product AS P INNER JOIN Category AS C ON P.Category_Id=C.Category_Id WHERE P.Status_Product="ACTIVE";

SELECT Distinct(P.Product_Title) FROM Product AS P INNER JOIN Image AS I ON I.Product_Id=P.Product_Id WHERE I.Image_Id=0;

SELECT * FROM Category ORDER BY Parent_Category ASC,Category_Title ASC;

Select Category.Category_Title from Category WHERE Category.Category_Title
NOT IN(Select  distinct Category.Parent_Category from Category);

SELECT P.Product_Title,P.Price,P.Description FROM Product AS P INNER JOIN Category AS C ON P.Category_Id=C.Category_Id WHERE C.Category_Title="Head Phones";

SELECT Product_Title FROM Product WHERE Quantity<50;

UPDATE Product SET Quantity=Quantity+100 WHERE Product_Id>1000;
SELECT * From Product;