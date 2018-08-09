import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeWithComparable implements Comparable<EmployeeWithComparable> {

    private int id;
    private String name;
    private String address;
  
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAdress() {
        return address;
    }

   

    public EmployeeWithComparable(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address=address;
    }

    @Override
    public int compareTo(EmployeeWithComparable emp) {    	
        return (this.id - emp.id);
    }

    @Override
    //this is required to print the user friendly information about the Employee
    public String toString() {
        return "\nid : " + this.id + ", name : " + this.name + ", address : " + this.address +"\n";
    }
    
    public static void main(String []arg){
    	List<EmployeeWithComparable> emploeeList=new ArrayList<EmployeeWithComparable>();
    	emploeeList.add(new EmployeeWithComparable(5,"Jitendra","Model Town"));
    	emploeeList.add(new EmployeeWithComparable(2,"Rahul","Malviya nagar"));
    	emploeeList.add(new EmployeeWithComparable(3,"Vaibhav","Vaishali nagar"));
    	emploeeList.add(new EmployeeWithComparable(1,"Ram","Pratap nagar"));
    	Collections.sort(emploeeList);
    	System.out.println(emploeeList);

    }

}