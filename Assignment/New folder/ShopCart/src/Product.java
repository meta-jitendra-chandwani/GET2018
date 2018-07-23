import java.util.Collection;

public class Product {
String Name;
int Price,Quantiy,Discount;

public Product() {
	Name = "";
	Price=0;
	Quantiy=0;
	Discount=0;
}
Product(String Name,int Price,int Quantity,int Discount){
	this.Name=Name;
	this.Price=Price;
	this.Quantiy=Quantity;
	this.Discount=Discount;
}

static Collection<? extends Product> setProduct() {
	new Product("Shirt", 1000, 0, 10);
	new Product("T_Shirt", 800, 0, 15);
	new Product("Shoe", 1600, 0, 20);
	new Product("Mobile", 7000, 0, 5);
	new Product("Laptop", 35000, 0, 30);
	new Product("Glasses", 1200, 0, 50);
}

}
