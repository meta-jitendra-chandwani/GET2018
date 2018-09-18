import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RemoveDuplicateUsingCollections {
	public static void main(String[] arg) {
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(new Employee(5, "Jitendra", "Model Town"));
		employeeList.add(new Employee(2, "Rahul", "Malviya nagar"));
		employeeList.add(new Employee(3, "Vaibhav", "Vaishali nagar"));
		employeeList.add(new Employee(1, "Ram", "Pratap nagar"));
		employeeList.add(new Employee(5, "Jitendra", "Model Town"));
		employeeList.add(new Employee(2, "Rahul", "Malviya nagar"));
		employeeList.add(new Employee(3, "Vaibhav", "Vaishali nagar"));
		employeeList.add(new Employee(1, "Ram", "Pratap nagar"));
		employeeList.add(new Employee(5, "Jitendra", "Model Town"));
		employeeList.add(new Employee(2, "Rahul", "Malviya nagar"));
		employeeList.add(new Employee(1, "Ram", "Pratap nagar"));

		
		HashSet<Employee> hashSet = new HashSet<Employee>();
		hashSet.addAll(employeeList);
		employeeList.clear();
		employeeList.addAll(hashSet);
		System.out.println(employeeList);
	}
}
