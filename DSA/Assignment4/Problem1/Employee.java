public class Employee {
	private int id;
	public String name;
	private String address;

	/**
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @return address
	 */
	public String getAdress() {
		return address;
	}

	/**
	 * 
	 * @param id
	 * @param name
	 * @param address
	 */
	public Employee(int id, String name, String address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}

	/**
	 * @param object
	 * @return boolean
	 */
	@Override
	public boolean equals(Object object) {
		if (object instanceof Employee) {
			return ((Employee) object).id == id;
		}
		return false;
	}

	/**
	 * @return hashCode of object id
	 */
	@Override
	public int hashCode() {
		return this.id;
	}

	/**
	 * @return - formatted object
	 */
	public String toString() {
		return "\nid : " + this.id + ", name : " + this.name + ", address : "
				+ this.address + "\n";

	}
}