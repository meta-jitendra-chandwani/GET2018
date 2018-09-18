import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Main{
	
	public static void main(String[] arg) {
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(new Employee(5, "Jitendra", "Model Town"));
		employeeList.add(new Employee(2, "Rahul", "Malviya nagar"));
		employeeList.add(new Employee(3, "Vaibhav","Vaishali nagar"));
		employeeList.add(new Employee(1, "Ram", "Pratap nagar"));

		Collections.sort(employeeList, new EmployeeWithComparator());
		System.out.println(employeeList);
	}
}