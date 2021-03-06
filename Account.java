public class Account {

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

	public int getAcc_no() {
		return Acc_no;
	}

	public void setInterest_rate(double interest_rate) {
		Account.interest_rate = interest_rate;
	}

	// member functions
	public int makeDeposit(int amount) {
		balance += amount;
		transactions++;
		System.out.println("Rs." + amount + " deposited.\nbalance= " + balance);
		return amount;
	}

	public boolean makeWithdrawal(int amount) {	//will return true when successful
		if (Checking == true) { // checking
			if (balance >= amount) {
				balance -= amount;
				transactions++;
				System.out.println("Rs." + amount + " withrawn.\nRemaining balance= " + balance);
				return true;
			} else {
				System.out.println("Error: Amount Exceeds Balance");
				return false;
			}
		} else if (Checking == false) { // savings
			if (balance + 5000 >= amount) {
				balance -= amount;
				transactions++;
				System.out.println("Rs." + amount + " withrawn.\nRemaining balance= " + balance);
				return true;
			} else {
				System.out.println("Error: Amount Exceeds Limit");
				return false;
			}
		}
		return false;
	}

	public int checkBalance() {
		System.out.println("Name: " + C.name + "\nBalance: Rs." + balance);
		return balance;
	}

	public double calculateZakat() {
		if (Checking == false) { // savings account
			if (balance >= 20000) {
				double zakat = (balance * 2.5) / 100;
				System.out.print("Zakat= Rs." + zakat + "\n");
				return zakat;
			} else {
				System.out.print("Balance lower than Rs.20000\n");
				return 0;
			}
		} else { // checking account
			System.out.print("No zakat for checking account\n");
			return 0;
		}
	}

	public double calculateInterest() {
		if (Checking == false) { // savings account
			double inter = balance * (interest_rate / 100);
			System.out.print("Interest =" + inter + "\n");
			return inter;
		} else {
			System.out.print("No interest for checking account\n");
			return 0;
		}
	}

	public boolean displayDeductions() {
		if (Checking == false) { // savings account
			double zakat = (balance * 2.5) / 100;
			System.out.print("Deductions\nZakat= Rs." + zakat);
			return true;
		} else {	//checking account
			double tax = 0;
			if (transactions > 2) {
				tax = transactions * 10;
			}
			System.out.print("Deductions\nTax= Rs." + tax);
			return true;
		}	
	}

	public boolean displayDetails() {
		System.out.println("Account Details");
		System.out.println("Customer name: " + C.getName());
		System.out.println("Account Number: " + Acc_no);
		System.out.println("Balance: " + balance);
		if (Checking == true) {
			System.out.println("Account Type: Checking");
		} else {
			System.out.println("Account Type: Savings");
		}
		return true;
	}

}
