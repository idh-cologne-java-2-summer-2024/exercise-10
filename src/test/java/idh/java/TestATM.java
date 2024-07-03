package idh.java;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import idh.java.ATM.IllegalInputException;

public class TestATM {

    ATM atm;

    @BeforeEach
    void setUp() {
	atm = new ATM();
    }

    @Test
    void testConvertToBillsCorrectBehaviour() throws IllegalInputException {

	int[] r = atm.convertToBills(5);

	assertEquals(1, r[6]);
	assertEquals(0, r[5]);

	assertArrayEquals(new int[] { 0, 0, 0, 0, 1, 1, 1 }, atm.convertToBills(35));
	assertArrayEquals(new int[] { 20, 0, 0, 0, 0, 0, 1 }, atm.convertToBills(10005));
	assertArrayEquals(new int[] { 0, 0, 0, 1, 1, 1, 0 }, atm.convertToBills(80));
	assertArrayEquals(new int[] { 0, 0, 1, 0, 1, 0, 0 }, atm.convertToBills(120));

	// largest integer divisible by 5
	assertArrayEquals(new int[] { 4294967, 0, 1, 0, 2, 0, 1 }, atm.convertToBills(Integer.MAX_VALUE - 2));
    }

    @Test
    void testConvertToBillsInputNegative() throws IllegalInputException {
	assertArrayEquals(new int[] { 0, 0, 0, 0, 0, 0, 0 }, atm.convertToBills(-5));
	assertArrayEquals(new int[] { 0, 0, 0, 0, 0, 0, 0 }, atm.convertToBills(-15));
	assertArrayEquals(new int[] { 0, 0, 0, 0, 0, 0, 0 }, atm.convertToBills(-1059385));

	// smallest integer
	assertArrayEquals(new int[] { 0, 0, 0, 0, 0, 0, 0 }, atm.convertToBills(Integer.MIN_VALUE));
    }

    @Test
    void testConvertToBillsInputZero() {
	assertThrows(IllegalInputException.class, () -> atm.convertToBills(7));

	// largest integer
	assertThrows(IllegalInputException.class, () -> atm.convertToBills(Integer.MAX_VALUE));
    }

}
