package test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import idh.java.ATM;
import idh.java.ATM.IllegalInputException;

public class ConvertToBillsTest {

	private static ATM atm;

	@BeforeAll
	public static void setupATM() {
		atm = new ATM();
	}

	@Test
	public void testMinAndMaxInput() {

		try {

			int inputMin = -2147483647;
			int[] assertedMin = { 0, 0, 0, 0, 0, 0, 0 };
			int[] resultMin = atm.convertToBills(inputMin);
			assertArrayEquals(assertedMin, resultMin);

			int inputMax = 2147483645;
			int[] assertedMax = { 4294967, 0, 1, 0, 2, 0, 1 };
			int[] resultMax = atm.convertToBills(inputMax);
			assertArrayEquals(assertedMax, resultMax);

		} catch (IllegalInputException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testNegativeInput() {

		try {
			int[] asserted = { 0, 0, 0, 0, 0, 0, 0 };
			int[] result = atm.convertToBills(-1);
			assertArrayEquals(asserted, result);

		} catch (IllegalInputException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testIllegalInput() {
		assertThrows(IllegalInputException.class,() -> atm.convertToBills(6));
	}

}
