import java.util.Comparator;

class EmployeeWithComparator implements Comparator<Employee> {

	/**
    * @return int value in form of 0,1,-1
    * 0 -  both are equal
    * 1 - first value is greater
    * -1 - second value is greater
    */
	@Override
	public int compare(Employee emp1, Employee emp2) {
		return (emp1.name).compareTo(emp2.name);
	}

}