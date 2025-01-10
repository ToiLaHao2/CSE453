package Q2.b_Money_Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import Q2.b_Money.Currency;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
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
		assertEquals("EUR", EUR.getName());
	}

	@Test
	public void testGetRate() {
		assertEquals(0.15, SEK.getRate());
	}

	@Test
	public void testSetRate() {
		DKK.setRate(0.24);
		assertTrue(0.24 == DKK.getRate());
	}

	// Test with SEK ; 0.15 => universal value with 1000 : 150
	@Test
	public void testGlobalValue() {
		assertEquals(150, SEK.universalValue(1000));
	}

	// Test with SEK : 1333 compare with DKK : 200 
	@Test
	public void testValueInThisCurrency() {
		assertEquals(1333, SEK.valueInThisCurrency(1000, DKK));
	}

}
