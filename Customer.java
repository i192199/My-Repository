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

}
