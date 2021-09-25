public class Customer {
	// Attributes
	public String name;
	private String address;
	private String phone_number;

	// Constructor

	public Customer(String Name, String Address, String Phone_num) {
		name = Name;
		address = Address;
		phone_number = Phone_num;
	}

	public Customer(Customer c) {
		name = c.name;
		address = c.address;
		phone_number = c.phone_number;
	}

	// Member functions

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
}
