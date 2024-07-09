package idh.java;

import org.junit.Before;
import org.junit.Test;

import idh.java.ATM.IllegalInputException;

public class ConverttoBuildsTest {

	private static ATM atm ;
	
	@Before
	public static void setupATM() {
		atm = new ATM();
	}
	
	@Test
	public void testMinAndMaxInput () {
	    try {
	    int inputMin = 5;
		int[] assertedMin = {0,0,0,0,0,1};
	    int[] resultMin = atm.convertToBills(inputMin);
	    assertArrayEquals(assertedMin,resultMin);
	    
	    int inputMax = 2789865;
	    int[] assertedMax = {4294967,0,1,0,2,0,1};
	    int[] resultMax = atm.convertToBills(inputMax);
	    assertArrayEquals(assertedMax, resultMax);
	    
	    } catch (IllegalInputException e) {
	    	e.printStackTrace(); }
	    }
	    @Test
	    public void testNegInput() {
	    	try {
	    	int[] asserted = {0,0,0,0,0,0};
	    	int[] result = atm.convertToBills(-1);
	    	assertArrayEquals(asserted,result);
	    	
	    	
	    }catch (IllegalINputExeption e ) {
	    	e.printStackTrace();
	    }
	}
	
	@Test 
	public void testIllegalInput() {
		assertThrows(IllegalInputExeption.class, ()-> atm.convertToBills(10));
	    
	    
	    }
}
