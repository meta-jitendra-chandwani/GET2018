
public class Query_Class {
	final static String SELECT_QUERY = "SELECT Order_Id,Order_Date,Order_Total FROM Orders WHERE Status LIKE '%Shipped%' && User_Id=? ORDER BY Order_Date DESC";
	final static String INSERT_QUERY="INSERT INTO Image (Image_Id,Product_Id) values(?,?)";
	final static String UPDATE_SAFE="SET SQL_SAFE_UPDATES = 0";
	final static String UPDATE_QUERY="UPDATE Product SET Status_Product='INACTIVE' WHERE Product_Id IN (SELECT P.Product_Id FROM (Select * from Product) AS P WHERE P.Product_Id NOT IN(SELECT DISTINCT(OP.Product_Id) FROM Order_Product OP INNER JOIN Orders O ON OP.Order_Id=O.Order_Id WHERE O.Order_Date >curdate()-365))";
	final static String QUERY="SELECT c.Category_Title, Count(c1.Category_Id) AS count_Of_Child FROM category c LEFT JOIN category c1 ON c.category_Id=c1.Parent_Id WHERE c.Parent_Id=0 GROUP BY c.Category_Title ORDER BY c.Category_Title";
}