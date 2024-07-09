package idh.java;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import idh.java.ATM;
import idh.java.ATM.IllegalInputException;

public class convertToBillsTest {

	private static ATM atm;
	
	@BeforeAll
	public static void ladeATM() {
		atm = new ATM();
	}
	
	@Test
	public void TestMinMax (){
		//strg + shift + o = Autoimport
		try {
			int min = 5;
			int[]predictedMinimum = {0,0,0,0,0,0,1};
			int[]resultMinimum = atm.convertToBills(min);
			assertArrayEquals(predictedMinimum, resultMinimum);
			
			int max = 2147483645;
			int[]predictedMaxEndWith5 = {4294967,0,1,0,2,0,1};
			int[]resultMaxEndWith5 = atm.convertToBills(max);
			assertArrayEquals(predictedMaxEndWith5, resultMaxEndWith5);
			
			
		} catch (IllegalInputException e) {
			e.printStackTrace();
		}
		
	}
	@Test
	public void TestNegative () {
		try {
			int negative = -234;
			int[]predictedNegative = {0,0,0,0,0,0,0};
			int[] resultNegative = atm.convertToBills(negative);
			assertArrayEquals(predictedNegative, resultNegative);
			
		} catch (IllegalInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
	}
	@Test
	public void TestNot5 () {
		
		assertThrows(IllegalInputException.class, ()-> atm.convertToBills(12));
	}

}
