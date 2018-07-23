
import java.util.ArrayList;
import java.util.List;

public class Product {
String Name;
int Price,Quantiy,Discount;
private List<Product> productList;

public Product() {
    productList = new ArrayList<>();
    productList.add(new Product("Shirt", 1000, 0, 10));
    productList.add(new Product("T_Shirt", 800, 0, 15));
    productList.add(new Product("Shoe", 1600, 0, 20));
    productList.add(new Product("Mobile", 7000, 0, 5));
    productList.add(new Product("Laptop", 35000, 0, 30));
    productList.add(new Product("Glasses", 1200, 0, 50));
}
Product(String Name,int Price,int Quantity,int Discount){
	this.Name=Name;
	this.Price=Price;
	this.Quantiy=Quantity;
	this.Discount=Discount;
}
 public List<Product> getProductList() {
       return productList;
   }


}
