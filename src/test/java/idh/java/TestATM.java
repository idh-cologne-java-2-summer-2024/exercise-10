package idh.java;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import idh.java.ATM.IllegalInputException;
import idh.java.ATM.WrapperClass;

public class TestATM {
	static ATM test1;
	WrapperClass w1 = new WrapperClass(); //No Enclosing Instance of type ATM available?... making WrapperClass static seems to help, no idea why though.
	WrapperClass w2 = new WrapperClass();
	int[] testMaxCash = new int[7];
	int[] testMinCash = new int[7];
	int huge = 2147483647;
	int tiny = -2147483647;
	
	//Creating a new static ATM Object to work with, needs to be static since BeforeAll is intended to run first before any Test Instances are created
	@BeforeAll
	public static void setUpATM() {
		test1 = new ATM();
	}
	
	//Playing around with @BeforeEach-Annotions, this is not needed
	@BeforeEach
	void Prep() {
		for (int i : testMaxCash) {
			testMaxCash[i] = huge;
		}

		for (int i : testMinCash) {
			if (i < 0) {
				testMaxCash[i] = 0;
			} else {
				testMaxCash[i] = tiny;
			}
		}
	}
//	Test Methods are always void, without parameters in () 
//	--> from Praktikum 09.07.24, does not work yet since convertToBills is protected, nvm renaming the package did the trick
	@Test
//	@DisplayName("Should run the convertToBills-Method with a big Integer and return an Array with 0s")
	public void testMinAndMaxInput() {
		
		try {
			
			int[] assertedMinimum = {0,0,0,0,0,0,0};
			int[] resultMinimum = test1.convertToBills(tiny);
			assertArrayEquals(assertedMinimum, resultMinimum);
			
			int inputMax = 2147483645;
			int[] assertedMaximum = {4294967,0,0,0,0,0,0};
			int[] resultMaximum = test1.convertToBills(huge);
			assertArrayEquals(assertedMaximum, resultMaximum);
			
		} catch(IllegalInputException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * Testing against negative inputs to the <code>convertToBills()-method</code>
	 */
	@Test
	@DisplayName("Should throw an IllegalInputException due to a negative Integer passed to the convertToBills-Method")
	void NegativeTestInput() {
//		Prep();
		int[] asserted = {0,0,0,0,0,0,0};
		int[] result;
		try {
			result = test1.convertToBills(-5);
			assertArrayEquals(asserted,result);
		} catch (IllegalInputException e) {
			e.printStackTrace();
		}
		
//		assertArrayEquals(tiny, test1.cashout(tiny)); //tiny is no array
	}
	
	/**
	 * Testing against illegal inputs, triggering the self-written (not by me) <code>IllegalInputException</code>
	 */
	@Test
	@DisplayName("Should throw an IllegalInputException")
	public void testIllegalInput() {
		assertThrows(IllegalInputException.class, () -> test1.convertToBills(6)); // ()-> code to be executed as an executable
		assertThrows(IllegalInputException.class, () -> test1.convertToBills(12));
	}
	}
	
	
	
	
//	------------------------------------------------------------------------------------- Trying stuff that doesn't want to work
//	@Test
//	void DivisionTest() throws IllegalInputException {
////		convertToBills Test --> returns Array, takes int amount
//			int[]expectArray = testMaxCash;
//			int[]expectArray2 = testMinCash;
////			w1.MethodCaller(huge);
////			w2.MethodCaller(tiny);
//			assertArrayEquals(w1.MethodCaller(huge),expectArray);
//			assertArrayEquals(w2.MethodCaller(tiny), expectArray2);
//	}
//	
//	@Test
//	void CashOutTest() {
////		Prep();
//		int[] testArrFilled = {100,100,100,100,100,100,100};
//		int[] testArrErr = {0,0,0,0,0,0,0};
////		WrapperClass w1 = new WrapperClass();
//		assertArrayEquals(huge, test1.cashout(huge)); //huge is not an array, though that is not even the biggest problem this code has
//		assertArrayEquals(w1.MethodCaller(huge),testArrFilled);
//		assertArrayEquals(w1.MethodCaller(tiny),testArrErr);
//	}
//
//	
//
//	@Test
//	void ThrowsExceptTest() {
////TODO: assertThrows
////		assertThrows(IllegalInputException.class,);
//		
//	}
//}
