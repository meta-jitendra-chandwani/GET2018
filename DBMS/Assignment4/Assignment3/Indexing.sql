/**
Identify the columns require indexing in order, product, category tables and create indexes.
**/

/**
Indexing Product_Id
**/
ALTER TABLE Product ADD INDEX Product_Index(Product_Id);
Show Index from Product;

/**
Indexing Order_Id
**/
ALTER TABLE Orders ADD INDEX Order_Index(Order_Id);
Show Index from Orders;

/**
Indexing Category_Id
**/
ALTER TABLE Category ADD INDEX Category_Index(Category_Id);
Show Index from Category;