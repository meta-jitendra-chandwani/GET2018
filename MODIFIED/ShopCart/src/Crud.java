
import java.util.List;
import java.util.Scanner;


public class Crud {
    Utility util=new Utility();
    Scanner input=new Scanner(System.in);
    
    
    void addItem() throws Exception{
    util.addToCart();
    System.out.print("Do you want to add more item into your cart(Y/N) : ");
        char reply = input.next().charAt(0);
        if (reply == 'Y' || reply == 'y') {
            addItem();
        } 
    }
	void removeItem() throws Exception{
		util.Remove();
	}
	void updateItem() throws Exception{
		util.updateCart();
	}
	void diplayItem() throws Exception{          
        
        util.cartDisplay();
	}

}
