public class Employee {
	private int id;
	public String name;
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

	public Employee(int id, String name, String address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Employee) {
			return ((Employee) obj).id == id;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return this.id;
	}

	public String toString() {
		return "\nid : " + this.id + ", name : " + this.name + ", address : "
				+ this.address + "\n";

	}
}