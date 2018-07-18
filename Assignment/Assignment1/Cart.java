import java.util.*;

interface Promotion 
{
	public void getMinimumPrice();
	public void setMinimumPrice();
	public void getFixedDiscount(double SUM);
	public double setFixedDiscount(double SUM,int discount);
}


class Store implements Promotion
{
    private Scanner sc = new Scanner(System.in); 
    String selected_item[] = new String[50];
	int selected_item_index = 0;
	int selected_item_quantity[] = new int[50];
	int selected_item_quantity_index = 0;
	int Discount_percentage = 0;

	Store(Map<String, Integer> map)
	{
		Option(map);		
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
	

	boolean isPromotionApplicable()
	{
//		if(java.time.LocalDate.now());  
		return true;
	}
	
	void Option(Map<String, Integer> map)
	{
		System.out.println("\n1. Add the item\n2. Update the Cart\n3. Display Cart Item\n4. Proceed to Bill");
		System.out.print("Enter your choice : ");
		int choose = sc.nextInt();
		switch(choose)
		{
		case 1: itemList(map);
				break;
		case 2: updateCart(map);
				break;
		case 3: displayItem(map);
				break;
		case 4: finalBill(map);
				break;
		default: System.out.print("There is no such option.");
		}
	}
	
	void itemList(Map<String, Integer> map)
	{
//		System.out.println("==========Here the list of Item==========");
		System.out.print("\n\t\tItem\t\t\t\tPrice\n");
		map.keySet().forEach(key -> System.out.println("\t\t"+key + "\t\t\t\t" + map.get(key)));
		this.addToCart(map);
	}
	
	void addToCart(Map<String, Integer> map)
	{
		System.out.print("\t\tChoose the Item to put into cart : ");
		String item_choose = sc.next();
		selected_item[selected_item_index] = item_choose;
		selected_item_index++;
		System.out.print("\t\tQuantity : ");
		int quantity = sc.nextInt();
		selected_item_quantity[selected_item_quantity_index] = quantity;
		selected_item_quantity_index++;
		System.out.print("Do you want to add more item into your cart(Y/N) : ");
        char reply = sc.next().charAt(0);
		if(reply == 'Y'||reply == 'y')
		{
			itemList(map);
		}
		else
		{
//			System.out.println("Here the item that you have add.");
			Option(map);
		}
	}
	
	void updateCart(Map<String, Integer> map)
	{
//		Display_item(map);
		if(selected_item_index == 0)
		{
			check(map);
		}
		else
		{	
		System.out.println("1. Remove Item\n2. Change the quantity");
		System.out.print("Enter your choice : ");
		int choose=sc.nextInt();
		switch(choose)
		{
		case 1: Remove(map);
				break;
		case 2: changeQuantity(map);
				break;
		default: System.out.print("There is no such option.");
		}
		}	
	}
	
	void Remove(Map<String, Integer> map)
	{
//		System.out.print("Please enter item name to update : ");
//		String remove_item=sc.next();
//		System.out.println(selected_item_index);
//		for(int i=0; i<selected_item_index; i++)
//	       {
//	           if(selected_item[i] == remove_item)
//	           {
//	               for(int j=i; j<(selected_item_index-1); j++)
//	               {
//	            	   selected_item[j] = selected_item[j+1];
//	               }
//	              
//	               break;
//	           }
//	       }
//		System.out.println(selected_item[0]);
//		Display_item(map);
	
	}
	
	void changeQuantity(Map<String, Integer> map)
	{
		System.out.print("Please enter item name to update : ");
		String update_item = sc.next();
		int index = 0;
		for (int i = 0; i < selected_item_index; i++)
		{
			if (selected_item[i] == update_item)
			{
				index = i;
			}
		}
		System.out.print("Enter Quantity : ");
		selected_item_quantity[index] = sc.nextInt();	
		displayItem(map);
	}
	
	void check(Map<String, Integer> map)
	{
		System.out.println("Sorry but there is no item in your cart to display");
		System.out.print("Do you want to add item into your cart(Y/N) : ");
		char reply = sc.next().charAt(0);
		if(reply == 'Y'||reply == 'y')
		{
			itemList(map);
		}
		else
		{
			Option(map);
		}
	}
	
	void displayItem(Map<String, Integer> map)
	{
		if(selected_item_index == 0)
		{
			check(map);
		}
		else
		{	
		int i = 0;
		System.out.println("Item\t\t\tQuantity");
		int temp = selected_item_index;
		while(temp > 0)
		{
			System.out.println(selected_item[i]+"\t\t\t"+selected_item_quantity[i]);
			temp--;
			i++;
		}
		System.out.print("Do you want to checkout(Y/N) : ");
		 char reply = sc.next().charAt(0);
			if(reply == 'Y'||reply == 'y')
			{
				finalBill(map);
			}
			else
			{
//				System.out.println("Do you want to add some more item or update item : \n1. Add Item\n2. Update Item\n");
//				int choose=sc.nextInt();
//				switch(choose){
//				case 1: Item_List(map);
//						break;
//				case 2: Update_Cart(map);
//						break;
//				default: System.out.print("There is no such option.");
//								}
				Option(map);
			}
		}	
	}
	
	void finalBill(Map<String, Integer> map)
	{
		if(selected_item_index==0)
		{
			check(map);
		}
		else
		{
		int i = 0;
		int temp = selected_item_index;
		double SUM = 0.0;
		System.out.println("Item\tQuantity\tPrice\tTotal");
		while(temp>0)
		{
		SUM += selected_item_quantity[i] * map.get(selected_item[i]);
		System.out.println(selected_item[i]+"\t"+ selected_item_quantity[i]+"\t\t"+ map.get(selected_item[i])+"\t"+selected_item_quantity[i]*map.get(selected_item[i]));
		temp--;
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

public class Cart 
{
	public static void main(String []args)
	{
		Map<String, Integer>  map = new HashMap<String, Integer>();
		    map.put("T-Shirt",150);
		    map.put("Shoe",180);
		    map.put("Shirt",1150);
		    map.put("Mobile",4500);
		    map.put("Glasses",520);
		 new Store(map);
	 }
}