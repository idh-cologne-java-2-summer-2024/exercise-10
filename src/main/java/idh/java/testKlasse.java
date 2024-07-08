package idh.java;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import idh.java.ATM.IllegalInputException;

class testKlasse {
	//private ATM atm;

	ATM atm = new ATM();


	@Test
	public void testEins() throws IllegalInputException {
		// 1. Bei einer durch fünf teilbaren Eingabe wird eine Stückelung erzeugt, die möglichst wenig Scheine verbraucht 
		assertArrayEquals(new int[] { 0, 0, 0, 0, 0, 0, 1 }, atm.convertToBills(5));
		assertArrayEquals(new int[] { 0, 0, 0, 0, 0, 2, 0 }, atm.convertToBills(20)); // 20 -> 2x10 falsch
		assertArrayEquals(new int[] { 0, 1, 0, 1, 0, 1, 1 }, atm.convertToBills(265)); // 200, 50, 10, 5
		assertArrayEquals(new int[] { 1, 0, 1, 1, 0, 1, 1 }, atm.convertToBills(665)); // 500, 100, 50, 10, 5
		assertArrayEquals(new int[] { 200, 0, 0, 0, 0, 0, 0 }, atm.convertToBills(100000)); // 100000
	}

	public void testZwei() throws IllegalInputException {
		// 2. Bei Eingabe einer negativen Zahl wird ein Array mit Nullen zurückgegeben.
		assertArrayEquals(new int[] { 0, 0, 0, 0, 0, 0, 0 }, atm.convertToBills(-50));
	}

	public void testDrei() {
		// 3. Bei Eingabe einer Zahl die nicht durch fünf teilbar ist, wird eine Exception der Klasse IllegalInputException geworfen.
		assertThrows(ATM.IllegalInputException.class, () -> atm.convertToBills(3));
		assertThrows(ATM.IllegalInputException.class, () -> atm.convertToBills(8));
	}

}
