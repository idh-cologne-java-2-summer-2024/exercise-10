package atmTests;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import idh.java.ATM;
import idh.java.ATM.IllegalInputException;

public class ConvertToBillsTest {
	private static ATM atm;
	//STRG + SHIFT + o -> autoimport
	
	@BeforeAll
	public static void setupATM() {
		atm = new ATM();}
	
	@Test
	public void testMinAndMaxInput() {
		try {
			int inputMin = 5;
			int[] assertedMinimum = {0,0,0,0,0,0,0};
			int[] resultMinimum = atm.convertToBills(inputMin);
			assertArrayEquals(assertedMinimum, resultMinimum);
			
			int inputMax = 2147483645;
			int[] assertedMaximum = {4294967,0,1,0,2,0,1};
			int[] resultMaximum = atm.convertToBills(inputMax);
			assertArrayEquals(assertedMaximum, resultMaximum);
			
		}catch (IllegalInputException e) {
			e.printStackTrace(); //wirft fehler zurück und man kann ermitteln wo und wann er passiert is
			}}
	
	@Test
	public void testNegativeInput() {
		try {
			int[] asserted = {0,0,0,0,0,0,0};
			int[] result = atm.convertToBills(-1);
			assertArrayEquals(asserted, result);
		}catch (IllegalInputException e) {
			e.printStackTrace();}}
	
	@Test
	public void testIllegalInput() {
		assertThrows(IllegalInputException.class, () -> atm.convertToBills(12));}}
