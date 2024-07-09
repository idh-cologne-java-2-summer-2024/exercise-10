package idh.java;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class TestConvertToBills extends ATM{
	
	private static ATM test;

    @BeforeAll
    public static void setUpOnce() {
    	test = new ATM();
    }
	
	@Test
	// tests the correct division of sums into the proper banknotes.
	public void testDivsion() {
		try {
		assertArrayEquals(new int[] {0,0,0,0,0,0,1}, convertToBills(5));
		assertArrayEquals(new int[] {0,0,0,0,1,0,0}, convertToBills(20));
		assertArrayEquals(new int[] {0,1,0,0,0,0,0}, convertToBills(200));
		assertArrayEquals(new int[] {2000,0,0,0,0,0,0}, convertToBills(1000000));
		
		} catch (IllegalInputException e) {
			
			assertFalse(false); // idk if I understood correctly, but this means,
			                    // that no exception should be happening with these inputs, no?
	
	    }
	}
	
	@Test 
	// tests if negative input numbers are met with an "empty" array
	public void testNegativeNumber() {
		
		try {
		assertArrayEquals(new int[] {0,0,0,0,0,0,0}, convertToBills(-1));
		
		} catch (IllegalInputException e) {
			
			assertTrue(true);
			
		}
	}
	 
	@Test
	// tests if invalid input numbers are correctly declined
	public void testWrongInput() {
		
		assertThrows(IllegalInputException.class, () -> test.convertToBills(4));
		
	}

}
