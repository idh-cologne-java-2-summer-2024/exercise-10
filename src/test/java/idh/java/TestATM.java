package idh.java;

import org.junit.jupiter.api.Test;

import idh.java.ATM.IllegalInputException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class TestATM {
	ATM atm = new ATM();
	
	public static void main(String[] args) {
		
	}
	
	@Test 
	public void testZero() {
		int[] i = {0, 0, 0, 0, 0, 0, 0};
		try {
			assertArrayEquals(i, atm.convertToBills(0));
		} catch (IllegalInputException e) {
			System.out.println("Test nicht bestanden. Illegal input exception!");
		}
	}
	
	@Test 
	public void test2885() {
		int[] i = {5, 1, 1, 1, 1, 1, 1};
		try {
			assertArrayEquals(i, atm.convertToBills(2885));
		} catch (IllegalInputException e) {
			System.out.println("Test nicht bestanden. Illegal input exception!");
		}
	}
	
	@Test 
	public void test5() {
		int[] i = {0, 0, 0, 0, 0, 0, 1};
		try {
			assertArrayEquals(i, atm.convertToBills(5));
		} catch (IllegalInputException e) {
			System.out.println("Test nicht bestanden. Illegal input exception!");
		}
	}
	
	@Test 
	public void test10() {
		int[] i = {0, 0, 0, 0, 0, 1, 0};
		try {
			assertArrayEquals(i, atm.convertToBills(10));
		} catch (IllegalInputException e) {
			System.out.println("Test nicht bestanden. Illegal input exception!");
		}
	}
	
	@Test 
	public void test20() {
		int[] i = {0, 0, 0, 0, 1, 0, 0};
		try {
			assertArrayEquals(i, atm.convertToBills(20));
		} catch (IllegalInputException e) {
			System.out.println("Test nicht bestanden. Illegal input exception!");
		}
	}
	
	@Test 
	public void test50() {
		int[] i = {0, 0, 0, 1, 0, 0, 0};
		try {
			assertArrayEquals(i, atm.convertToBills(50));
		} catch (IllegalInputException e) {
			System.out.println("Test nicht bestanden. Illegal input exception!");
		}
	}
	
	@Test 
	public void test100() {
		int[] i = {0, 0, 1, 0, 0, 0, 0};
		try {
			assertArrayEquals(i, atm.convertToBills(100));
		} catch (IllegalInputException e) {
			System.out.println("Test nicht bestanden. Illegal input exception!");
		}
	}
	
	@Test 
	public void test200() {
		int[] i = {0, 1, 0, 0, 0, 0, 0};
		try {
			assertArrayEquals(i, atm.convertToBills(200));
		} catch (IllegalInputException e) {
			System.out.println("Test nicht bestanden. Illegal input exception!");
		}
	}
	
	@Test 
	public void test500() {
		int[] i = {1, 0, 0, 0, 0, 0, 0};
		try {
			assertArrayEquals(i, atm.convertToBills(500));
		} catch (IllegalInputException e) {
			System.out.println("Test nicht bestanden. Illegal input exception!");
		}
	}
	
	@Test 
	public void test455() {
		int[] i = {0, 2, 0, 1, 0, 0, 1};
		try {
			assertArrayEquals(i, atm.convertToBills(455));
		} catch (IllegalInputException e) {
			System.out.println("Test nicht bestanden. Illegal input exception!");
		}
	}
	
	@Test 
	public void testNegative() {
		int[] i = {0, 0, 0, 0, 0, 0, 0};
		try {
			assertArrayEquals(i, atm.convertToBills(-5));
		} catch (IllegalInputException e) {
			System.out.println("Test nicht bestanden. Illegal input exception!");
		}
	}
	
	@Test 
	public void testIllegalInput() {
		assertThrows(IllegalInputException.class,() -> atm.convertToBills(1));
	}
}