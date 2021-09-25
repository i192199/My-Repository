import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestCases {

	Customer C;
	Account A1;
	Account A2;

	@Before
	public void setUp() {
		System.out.println("Before Executed:");
		C = new Customer("Abubakr", "Islamabad", "03005555555");
		A1 = new Account(C, false); // Savings Account
		A2 = new Account(C, true); // Checking Account
	}

	@After
	public void tearDown() {
		System.out.println("After Executed:");
		System.out.println();
	}

	@Test
	public void test01() { // Positive Test Case
		System.out.println("Test 1 Executed:");
		int result = A1.makeDeposit(10000);
		assertEquals(10000, result);
	}

	@Test
	public void test02() { // Negative Test Case
		System.out.println("Test 2 Executed:");
		int result = A1.makeDeposit(10000);
		assertNotEquals(100000, result);
	}

	@Test
	public void test03() { // Positive Test Case
		System.out.println("Test 3 Executed:");
		A1.makeDeposit(10000);
		boolean result = A1.makeWithdrawal(10000);
		assertTrue(result);
	}

	@Test
	public void test04() { // Negative Test Case
		System.out.println("Test 4 Executed:");
		A2.makeDeposit(10000);
		boolean result = A2.makeWithdrawal(10001);
		// amount to be withdrawn would exceed limit so false.
		assertFalse(result);
	}

	@Test
	public void test05() { // Positive Test Case
		System.out.println("Test 5 Executed:");
		A2.makeDeposit(10000);
		int result = A2.checkBalance();
		assertEquals(10000, result);
	}

	@Test
	public void test06() { // Negative Test Case
		System.out.println("Test 6 Executed:");
		A2.makeDeposit(10000);
		int result = A2.checkBalance();
		assertNotEquals(100000, result);
	}

	@Test
	public void test07() { // Positive Test Case
		System.out.println("Test 7 Executed:");
		A1.makeDeposit(200000);
		double result = A1.calculateZakat();
		double zakat = (200000 * 2.5) / 100;
		assertEquals((int) zakat, (int) result);
	}

	@Test
	public void test08() { // Negative Test Case
		System.out.println("Test 8 Executed:");
		A2.makeDeposit(200000);
		double result = A2.calculateZakat(); // 0 zakat on checking account
		double zakat = (200000 * 2.5) / 100;
		assertNotEquals((int) zakat, (int) result);
	}

	@Test
	public void test09() { // Positive Test Case
		System.out.println("Test 9 Executed:");
		A1.makeDeposit(200000);
		double result = A1.calculateInterest();
		double interest = 200000 * (9.0 / 100.0);
		assertEquals((int) interest, (int) result);
	}

	@Test
	public void test10() { // Negative Test Case
		System.out.println("Test 10 Executed:");
		A2.makeDeposit(200000);
		double result = A2.calculateInterest(); // No interest for checking account
		double interest = 200000 * (9.0 / 100.0);
		assertNotEquals((int) interest, (int) result);
	}
	@Test
	public void test11() { // Positive Test Case
		System.out.println("Test 11 Executed:");
		boolean b=A2.displayDeductions();
		assertTrue(b);		
	}
	@Test
	public void test12() { // Positive Test Case
		System.out.println("Test 12 Executed:");
		boolean b=A2.displayDetails();
		assertTrue(b);		
	}
	@Test
	public void test13() { // Positive Test Case
		System.out.println("Test 13 Executed:");
		boolean b=A1.displayDetails();
		assertTrue(b);		
	}
	@Test
	public void test14() { // Positive Test Case
		System.out.println("Test 14 Executed:");
		boolean b=A1.displayDeductions();
		assertTrue(b);		
	}
}
