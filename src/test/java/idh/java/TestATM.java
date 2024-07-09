package idh.java;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestATM {
    ATM atm;

    @BeforeEach public void beforeEach() {
        atm = new ATM();
    }

    /*
    Bei einer durch fünf teilbaren Eingabe wird eine Stückelung erzeugt, die möglichst wenig Scheine verbraucht
    (d.h. es werden immer möglichst große Scheine ausgegeben).
    Testen Sie dies mit einer Reihe von möglichen Eingaben.
    Achten Sie dabei auf extreme Eingaben, also mit kleinst- und größtmöglichen Zahlen.
     */
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

    /*
    Bei Eingabe einer negativen Zahl wird ein Array mit Nullen zurückgegeben.
     */
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

    /*
    Bei Eingabe einer Zahl, die nicht durch fünf teilbar ist, wird eine Exception der Klasse IllegalInputException
    geworfen.
     */
    @Test public void testIllegalInputException() {
        assertThrows(IllegalInputException.class, () -> atm.convertToBills(2));
    }
}
