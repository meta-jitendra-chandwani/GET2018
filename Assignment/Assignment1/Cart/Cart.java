import java.util.ArrayList;
import java.util.List;

public class Cart {
    String Name;
    int Price,Quantity,Discount;
    private final List<Cart> cartList = new ArrayList<>();
    
    Cart(){
//        addToCardList()
    }
   
    Cart(String Name,int Price,int Quantity,int Discount){  
    this.Name=Name;
    this.Price=Price;
    this.Quantity=Quantity;
    this.Discount=Discount;
//    addToCardList();
    }
    
    public List<Cart> getCartList() {    
       return cartList;
   }
    
    public void addToCardList(){
        cartList.add(new Cart(Name,Price,Quantity,Discount));
    }
    
}