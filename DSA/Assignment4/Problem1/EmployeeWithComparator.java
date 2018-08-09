import java.util.Comparator;

class EmployeeWithComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee emp1, Employee emp2) {
		return (emp1.name).compareTo(emp2.name);
	}

}