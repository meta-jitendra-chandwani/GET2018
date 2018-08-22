
public class Query_Class {
	final static String SELECT_QUERY = "SELECT Order_Id,Order_Date,Order_Total FROM Orders WHERE Status LIKE '%Shipped%' && User_Id=? ORDER BY Order_Date DESC";
	final static String INSERT_QUERY="INSERT INTO Image (Image_Id,Product_Id) values(?,?)";
	final static String UPDATE_SAFE="SET SQL_SAFE_UPDATES = 0";
	final static String UPDATE_QUERY="UPDATE Product SET Status_Product='INACTIVE' WHERE Product_Id IN (SELECT P.Product_Id FROM (Select * from Product) AS P WHERE P.Product_Id NOT IN(SELECT DISTINCT(OP.Product_Id) FROM Order_Product OP INNER JOIN Orders O ON OP.Order_Id=O.Order_Id WHERE O.Order_Date >curdate()-365))";
//	final static String CREATE_PROCEDURE = "DROP PROCEDURE value;"+
//			"DELIMITER $$ "+
//			"CREATE PROCEDURE value() "+
//			"BEGIN"+ 
//			"DECLARE value int;"+ 
//			"(Select count(Category_Id) into Value from category where parent_category like 'Top%');"+ 
//			"Select C.Parent_Category AS Parent,Count(C.Category_Title) AS Child_Count from Category C group by Parent_Category Order BY Parent_category LIMIT value ;"+ 
//			"END $$";
	final static String CALL_PROCEDURE="Call value";

}
