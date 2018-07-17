package cart;
import java.util.*;

interface Promotion 
{
	public void getMinimumPrice();
	public void setMinimumPrice();
	public void getFixedDiscount(double SUM);
	public double setFixedDiscount(double SUM,int discount);
       	boolean isPromotionApplicable();

}


class Store implements Promotion
{
    private Scanner sc = new Scanner(System.in); 
    List<String> selected_item;
    CURD curd=new CURD();
    List<Integer> selected_item_quantity;
    int Discount_percentage = 0;

    Store(HashMap<String, Integer> map)
	{
        this.selected_item_quantity = new ArrayList<>();
        this.selected_item = new ArrayList<>();
        }
        
    public List<Integer> getselected_item_quantity() {
            return selected_item_quantity;
        }
 	
    public List<String> getselected_item() {
            return selected_item;
        }
	
    enum PromotionEnum 
	{
		T_Shirt("T15", "2018-07-15", "2018-08-15"),
		Shoe("SHOE5", "2018-07-15", "2018-08-15"),
		Shirt("SHIRT10", "2018-07-15", "2018-08-15"),
		Mobile("MOB5", "2018-07-15", "2018-08-15"),
		Glasses("GLASS40", "2018-07-15", "2018-08-15");

		private String code,startDate,endDate;  
		private PromotionEnum(String code,String startDate,String endDate)
		{  
		this.code = code;  
		this.startDate = startDate;  
		this.endDate = endDate;  
		}  
        }
	

    @Override
	public boolean isPromotionApplicable()
	{
//		if(java.time.LocalDate.now());  
		return true;
	}
        
	void check(HashMap<String, Integer> map)
	{
		System.out.println("Sorry but there is no item in your cart to display");
		System.out.print("Do you want to add item into your cart(Y/N) : ");
		char reply = sc.next().charAt(0);
		if(reply == 'Y'||reply == 'y')
		{
                   
                curd.itemList(map);
		}
		else
		{
                    curd.Option();
		}
	}
	
	
	
	void finalBill(HashMap<String, Integer> map)
	{
		if(selected_item.isEmpty())
		{
			check(map);
		}
		else
		{
		int i = 0;
		int selected_item_size = selected_item.size();
		double SUM = 0.0;
		System.out.println("Item\tQuantity\tPrice\tTotal");
		while(selected_item_size>0)
		{
		SUM += selected_item_quantity.get(i) * map.get(selected_item.get(i));
		System.out.println(selected_item.get(i)+"\t"+ selected_item_quantity.get(i)+"\t\t"+ map.get(selected_item.get(i))+"\t"+selected_item_quantity.get(i)*map.get(selected_item.get(i)));
		selected_item_size--;
		i++;
		}
		System.out.println("Total Amount : "+SUM);
		getFixedDiscount(SUM);
		double amount = setFixedDiscount(SUM,Discount_percentage);
		System.out.println("Discount % : "+Discount_percentage);
		System.out.println("Total Amount after avail Discount: "+amount);
		}
	}

	@Override
	public void getMinimumPrice() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMinimumPrice() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getFixedDiscount(double SUM) 
	{
            
		if((1000 < SUM)&&(SUM < 5000))
		{
			Discount_percentage = 5;
		}
		else if(SUM >= 5000)
		{
			Discount_percentage = 10;
		}
				
	}

	@Override
	public double setFixedDiscount(double SUM,int discount) 
	{
		double sum = SUM;
		int Discount = discount;
		sum = sum * (100 - Discount) / 100;
		return sum;
	}
}

//public class Cart 
//{
//	public static void main(String []args)
//	{
//            Product product=new Product();
//		HashMap<String, Integer> map = product.getPeopleMap();
//                    product.setProduct(map);
//
//                Store store = new Store(map);
//	 }
//}
