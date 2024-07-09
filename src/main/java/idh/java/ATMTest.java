package idh.java;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestATM {
    ATM atm;

    @BeforeEach public void beforeEach() {
        atm = new ATM();
    }

    
    @Test public void testDivideBy5_1() throws ATM.IllegalInputException {
        int[] expected = new int[]{1,0,0,0,0,0,0};
        assertArrayEquals(expected, atm.convertToBills(500));
    }

    @Test public void testDivideBy5_2() throws ATM.IllegalInputException {
        int[] expected = new int[]{1,1,1,1,2,0,1};
        assertArrayEquals(expected, atm.convertToBills(895));
    }

    @Test public void testDivideBy5_3() throws ATM.IllegalInputException {
        int[] expected = new int[]{0,0,0,0,0,0,0};
        assertArrayEquals(expected, atm.convertToBills(0));
    }

    @Test public void testDivideBy5_4() throws ATM.IllegalInputException {
        int[] expected = new int[]{100,0,0,0,0,0,0};
        assertArrayEquals(expected, atm.convertToBills(50000));
    }

    
    @Test public void testNegativeInput_1() throws ATM.IllegalInputException {
        int[] expected = new int[] {0,0,0,0,0,0,0};
        assertArrayEquals(expected, atm.convertToBills(-1));
    }

    @Test public void testNegativeInput_2() throws ATM.IllegalInputException {
        int[] expected = new int[] {0,0,0,0,0,0,0};
        assertArrayEquals(expected, atm.convertToBills(-2));
    }

    @Test public void testNegativeInput_3() throws ATM.IllegalInputException {
        int[] expected = new int[] {0,0,0,0,0,0,0};
        assertArrayEquals(expected, atm.convertToBills(-1000));
    }

    
    
    @Test public void testIllegalInputException_1() {
        assertThrows(ATM.IllegalInputException.class, () -> atm.convertToBills(1));
    }

    @Test public void testIllegalInputException_2() {
        assertThrows(ATM.IllegalInputException.class, () -> atm.convertToBills(9999));
    }

    @Test public void testIllegalInputException_3() {
        assertThrows(ATM.IllegalInputException.class, () -> atm.convertToBills(999999999));
    }
}