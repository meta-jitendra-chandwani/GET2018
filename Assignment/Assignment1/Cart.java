import java.util.*;


class Store{
    private Scanner sc=new Scanner(System.in); 
    
	String selected_item[]=new String[50];
	int selected_item_index=0;
	int selected_item_quantity[]=new int[50];
	int selected_item_quantity_index=0;
	
	Store(Map<String, Integer> map){
		Option(map);		
    }
	
	void Option(Map<String, Integer> map)
	{
		System.out.println("1. Add the item\n2. Update the Cart\n3. Display Cart Item\n4. Proceed to Bill");
		System.out.print("Enter your choice : ");
		int choose=sc.nextInt();
		switch(choose){
		case 1: Item_List(map);
				break;
		case 2: Update_Cart(map);
				break;
		case 3: Display_item(map);
				break;
		case 4: Bill(map);
				break;
		default: System.out.print("There is no such option.");
		}
	}
	
	void Item_List(Map<String, Integer> map){
//		System.out.println("==========Here the list of Item==========");
		System.out.print("\t\tItem\t\t\t\tPrice\n");
				map.keySet().forEach(key -> System.out.println("\t\t"+key + "\t\t\t\t" + map.get(key)));
		this.Add_to_cart(map);
	}
	
	void Add_to_cart(Map<String, Integer> map){
		System.out.print("\t\tChoose the Item to put into cart : ");
		String item_choose=sc.next();
		selected_item[selected_item_index]=item_choose;
		selected_item_index++;
		System.out.print("\t\tQuantity : ");
		int quantity = sc.nextInt();
		selected_item_quantity[selected_item_quantity_index]=quantity;
		selected_item_quantity_index++;
		System.out.print("Do you want to add more item into your cart(Y/N) : ");
        char reply = sc.next().charAt(0);
		if(reply=='Y'||reply=='y'){
			Item_List(map);
		}
		else{
			System.out.println("Here the item that you have add.");
			Option(map);
		}
	}
	void Update_Cart(Map<String, Integer> map){
//		Display_item(map);
		if(selected_item_index==0){
			check(map);
		}
		else{	
		System.out.println("1. Remove Item\n2. Change the quantity");
		System.out.print("Enter your choice : ");
		int choose=sc.nextInt();
		switch(choose){
		case 1: Remove(map);
				break;
		case 2: Change_quantity(map);
				break;
		default: System.out.print("There is no such option.");
		}
		
		
		}	
	}
	
	void Remove(Map<String, Integer> map){
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
	void Change_quantity(Map<String, Integer> map){
		System.out.print("Please enter item name to update : ");
		String update_item=sc.next();
		int index=0;
		for (int i = 0; i < selected_item_index; i++){
			if (selected_item[i] == update_item){
				index=i;
			}}
		System.out.print("Enter Quantity : ");
		selected_item_quantity[index]=sc.nextInt();	
		Display_item(map);
	}
	void check(Map<String, Integer> map){
		System.out.println("Sorry but there is no item in your cart to display");
		System.out.print("Do you want to add item into your cart(Y/N) : ");
		char reply = sc.next().charAt(0);
		if(reply=='Y'||reply=='y'){
			Item_List(map);
		}
		else{
			Option(map);
		}
	}
	void Display_item(Map<String, Integer> map){
		if(selected_item_index==0){
			check(map);
		}
		else{			
		
		int i=0;
		System.out.println("Item\t\t\tQuantity");
		int temp=selected_item_index;
		while(temp>0){
			System.out.println(selected_item[i]+"\t\t\t"+selected_item_quantity[i]);
			temp--;
			i++;
		}
		System.out.print("Do you want to checkout(Y/N) : ");
		 char reply = sc.next().charAt(0);
			if(reply=='Y'||reply=='y'){
				Bill(map);
			}
			else{
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
	void Bill(Map<String, Integer> map){
		if(selected_item_index==0){
			check(map);
		}
		else{
		int i=0;
		int temp=selected_item_index;
		int sum=0;
		System.out.println("Item\tQuantity\tPrice\tTotal");
		while(temp>0){
			sum+=selected_item_quantity[i]*map.get(selected_item[i]);
		System.out.println(selected_item[i]+"\t"+ selected_item_quantity[i]+"\t\t"+ map.get(selected_item[i])+"\t"+selected_item_quantity[i]*map.get(selected_item[i]));
		temp--;
		i++;
	}
		System.out.println("Total Amount : "+sum);
		}
	}
}
public class Cart {
	public static void main(String []args){
		Map<String, Integer>  map = new HashMap<String, Integer>();
		    map.put("Item1",150);
		    map.put("Item2",180);
		    map.put("Item3",1150);
		    map.put("Item4",450);
		    map.put("Item5",520);
	    Store store=new Store(map);
	    }
}