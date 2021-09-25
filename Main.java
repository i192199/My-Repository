import java.util.Random;
import java.util.Scanner; // Import the Scanner class

//import java.util.*;

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
			int acc = 0;
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
				double rate = myObj.nextDouble();
				if (A[0] != null) {
					A[0].setInterest_rate(rate);
				} else {
					Customer C2 = new Customer("name", "Add", "0300");
					A[0] = new Account(C2, true);
					A[0].setInterest_rate(rate);
					A[0] = null;
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
		} while (input != 0);
	}

}
