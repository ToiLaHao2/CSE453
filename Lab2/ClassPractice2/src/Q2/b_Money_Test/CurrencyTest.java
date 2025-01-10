package Q2.b_Money_Test;


import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import Q2.b_Money.Currency;

public class CurrencyTest {
	Currency SEK, DKK, NOK, EUR;
	
	@BeforeAll
	public void setUp() throws Exception {
		/* Setup currencies with exchange rates */
		SEK = new Currency("SEK", 0.15);
		DKK = new Currency("DKK", 0.20);
		EUR = new Currency("EUR", 1.5);
	}

	@Test
	public void testGetName() {
		fail("Write test case here");
	}
	
	@Test
	public void testGetRate() {
		fail("Write test case here");
	}
	
	@Test
	public void testSetRate() {
		fail("Write test case here");
	}
	
	@Test
	public void testGlobalValue() {
		fail("Write test case here");
	}
	
	@Test
	public void testValueInThisCurrency() {
		fail("Write test case here");
	}

}
