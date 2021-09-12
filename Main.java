import java.util.Random;
import java.util.Scanner; // Import the Scanner class

//import java.util.*;
class Customer {
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

class Account {
	// Attributes
	private Customer C;
	private int Acc_no;
	private static int previous_no = 1102561; // Random Account number to begin with
	private static double interest_rate = 9; // 9% by default
	private boolean Checking; // 0 being savings, 1 being checking
	private int balance;
	private int transactions; // number of transactions

	Account(Customer c, boolean type) {
		C = new Customer(c);
		Acc_no = previous_no + 1;
		previous_no++;
		balance = 0;
		Checking = type;
		transactions = 0;
	}

	// Setters and Getters
	public Customer getC() {
		return C;
	}

	public void setC(Customer c) {
		C = c;
	}

	public int getAcc_no() {
		return Acc_no;
	}

	public void setAcc_no(int acc_no) {
		Acc_no = acc_no;
	}

	public static int getPrevious_no() {
		return previous_no;
	}

	public static void setPrevious_no(int previous_no) {
		Account.previous_no = previous_no;
	}

	public static double getInterest_rate() {
		return interest_rate;
	}

	public void setInterest_rate(double interest_rate) {
		Account.interest_rate = interest_rate;
	}

	public boolean isChecking() {
		return Checking;
	}

	public void setChecking(boolean checking) {
		Checking = checking;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getTransactions() {
		return transactions;
	}

	public void setTransactions(int transactions) {
		this.transactions = transactions;
	}

	// member functions
	public void makeDeposit(int amount) {
		balance += amount;
		transactions++;
		System.out.println("Rs." + amount + " deposited.\nbalance= " + balance);
	}

	public void makeWithdrawal(int amount) {
		if (Checking == true) { // checking
			if (balance >= amount) {
				balance -= amount;
				transactions++;
				System.out.println("Rs." + amount + " withrawn.\nRemaining balance= " + balance);
			} else {
				System.out.println("Error: Amount Exceeds Balance");
			}
		} else if (Checking == false) { // savings
			if (balance + 5000 >= amount) {
				balance -= amount;
				transactions++;
				System.out.println("Rs." + amount + " withrawn.\nRemaining balance= " + balance);
			} else {
				System.out.println("Error: Amount Exceeds Limit");
			}
		}
	}

	public void checkBalance() {
		System.out.println("Name: " + C.name + "\nBalance: Rs." + balance);
	}

	public void calculateZakat() {
		if (Checking == false) { // savings account
			if (balance >= 20000) {
				double zakat = (balance * 2.5) / 100;
				System.out.print("Zakat= Rs." + zakat + "\n");
			} else {
				System.out.print("Balance lower than Rs.20000\n");
			}
		} else { // checking account
			System.out.print("No zakat for checking account\n");
		}
	}

	public void calculateInterest() {
		if (Checking == false) { // savings account
			double inter = balance * (interest_rate / 100);
			System.out.print("Interest =" + inter + "\n");
		} else {
			System.out.print("No interest for checking account\n");
		}
	}

	public void displayDeductions() {
		if (Checking == false) { // savings account
			double zakat = (balance * 2.5) / 100;
			System.out.print("Deductions\nZakat= Rs." + zakat);
		} else {
			double tax = 0;
			if (transactions > 2) {
				tax = transactions * 10;
			}
			System.out.print("Deductions\nTax= Rs." + tax);
		}
	}

	public void displayDetails() {
		System.out.println("Account Details");
		System.out.println("Customer name: " + C.getName());
		System.out.println("Account Number: " + Acc_no);
		System.out.println("Balance: " + balance);
		if (Checking == true) {
			System.out.println("Account Type: Checking");
		} else {
			System.out.println("Account Type: Savings");
		}
	}
}

public class Main {
	public static void main(String[] args) {
		Scanner myObj = new Scanner(System.in); // Create a Scanner object
		Customer C[] = new Customer[100];
		Account A[] = new Account[100];
		int input = 0;
		do {
			System.out.println("Choose one of the following options by pressing entering number");
			System.out.println("1.Open a new account");
			System.out.println("2.Close an account");
			System.out.println("3.Perform an account operation");
			System.out.println("4.Specify interest rate");
			System.out.println("5.Display all account details");
			System.out.println("Enter 0 to quit");
			input = myObj.nextInt(); // Read user input
			int acc=0;
			switch (input) {
			case 1:
				System.out.println("Enter details of customer");
				System.out.print("Name: ");
				String n = myObj.nextLine();
				System.out.print("Address: ");
				String add = myObj.nextLine();
				System.out.print("Phone number: ");
				String ph = myObj.nextLine();
				System.out.println("Account type\n 1.Checking \n2.Savings");
				int check = myObj.nextInt();
				for (int i = 0; i < 100; i++) {
					if (C[i] == null) {
						C[i] = new Customer(n, add, ph);
						for (int j = 0; j < 100; j++) {
							if (A[j] == null) {
								if (check == 1) {
									A[j] = new Account(C[i], true); // Checkings
								} else {
									A[j] = new Account(C[i], false); // savings
								}
								System.out.println("Account created");
								A[j].displayDetails();
								break;
							}
						}
						break;
					}
				}
				break;
			case 2:
				System.out.println("Enter account number to be closed");
				acc = myObj.nextInt();
				for (int i = 0; i < 100; i++) {
					if (A[i] != null) {
						if (A[i].getAcc_no() == acc) {
							A[i] = null;
							System.out.println("Account closed");
							break;
						}
					}
				}
				System.out.println("Account not found");
				break;
			case 3:
				System.out.println("Enter account number to make operation");
				acc = myObj.nextInt();
				for (int i = 0; i < 100; i++) {
					if (A[i] != null) {
						if (A[i].getAcc_no() == acc) {
							System.out.println("Choose one of the following options by pressing entering number");
							System.out.println("1.Make deposit");
							System.out.println("2.Make withdrawal");
							System.out.println("3.Check balance");
							System.out.println("4.print statement");
							System.out.println("5.Transfer amount");
							System.out.println("6.Calculate Zakat");
							System.out.println("7.Display deductions");
							int input2 = myObj.nextInt(); // Read user input
							int amount = 0;
							switch (input2) {
							case 1:
								System.out.println("Enter amount to be deposited");
								amount = myObj.nextInt(); // Read amount
								A[i].makeDeposit(amount);
								break;
							case 2:
								System.out.println("Enter amount to be withdrwan");
								amount = myObj.nextInt(); // Read amount
								A[i].makeDeposit(amount);
								break;
							case 3:
								A[i].checkBalance();
								break;
							case 4:
								A[i].displayDetails();
								break;
							case 5:
								System.out.println("Enter amount to be transeferred");
								amount = myObj.nextInt(); // Read amount
								System.out.println("Enter account number to be transeferred to");
								acc = myObj.nextInt();
								A[i].makeWithdrawal(amount);
								System.out.println("Amount transferred");
								break;
							case 6:
								A[i].calculateZakat();
								break;
							case 7:
								A[i].displayDeductions();
							}

							// A[i]=null;
							break;
						}
					}
				}
				break;
			case 4:
				System.out.println("Enter Interest rate %");
				double rate=myObj.nextDouble();
				if (A[0] != null) {
					A[0].setInterest_rate(rate);
				}
				else {
					Customer C2= new Customer("name", "Add", "0300");
					A[0]= new Account(C2, true);
					A[0].setInterest_rate(rate);
					A[0]=null;
				}
				System.out.println("Interest rate changed");
				break;
			case 5:
				for (int i = 0; i < 100; i++) {
					if (A[i] != null) {
						A[i].displayDetails();
					}
				}
				break;
			case 6:
				for (int i = 0; i < 100; i++) {
					if (A[i] != null) {
						A[i].displayDeductions();
					}
				}
				break;
			}
		}while(input!=0);
}

}
