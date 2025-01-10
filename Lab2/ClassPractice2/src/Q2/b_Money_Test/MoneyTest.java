package Q2.b_Money_Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import Q2.b_Money.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MoneyTest {
	Currency SEK, DKK, NOK, EUR;
	Money SEK100, EUR10, SEK200, EUR20, SEK0, EUR0, SEKn100;

	@BeforeAll
	public void setUp() throws Exception {
		SEK = new Currency("SEK", 0.15);
		DKK = new Currency("DKK", 0.20);
		EUR = new Currency("EUR", 1.5);
		SEK100 = new Money(10000, SEK);
		EUR10 = new Money(1000, EUR);
		SEK200 = new Money(20000, SEK);
		EUR20 = new Money(2000, EUR);
		SEK0 = new Money(0, SEK);
		EUR0 = new Money(0, EUR);
		SEKn100 = new Money(-10000, SEK);
	}

	@Test
	public void testGetAmount() {
		assertEquals(10000, SEK100.getAmount());
	}

	@Test
	public void testGetCurrency() {
		assertEquals(SEK, SEK100.getCurrency());
	}

	@Test
	public void testToString() {
		assertEquals("10000 SEK", SEK100.toString());
	}

	@Test
	public void testGlobalValue() {
		assertEquals(1500, SEK100.universalValue());
	}

	@Test
	public void testEqualsMoney() {
		Money testMoneyWithSEK = new Money(10000, SEK);
		Money testMoneyWithDKK = new Money(10000, DKK);
		assertTrue(SEK100.equals(testMoneyWithSEK));
		assertFalse(SEK100.equals(testMoneyWithDKK));
	}

	// 1000 in dkk = 1500 => 2500
	@Test
	public void testAdd() {
		Money testAddMoneyWithDKK = new Money(10000, DKK);
		Money moneyAfterAdd = SEK100.add(testAddMoneyWithDKK);
		assertEquals(new Money(17500, SEK), moneyAfterAdd);
	}

	@Test
	public void testSub() {
		Money testSubMoneyWithDKK = new Money(10000, DKK);
		Money moneyAfterSub = SEK100.sub(testSubMoneyWithDKK);
		assertEquals(new Money(2500, SEK), moneyAfterSub);
	}

	@Test
	public void testIsZero() {
		assertTrue(SEK0.isZero());
		assertFalse(SEK100.isZero());
	}

	@Test
	public void testNegate() {
		assertEquals(SEKn100, SEK100.negate());
	}

	@Test
	public void testCompareTo() {
		assertThrows(Exception.class, ()->SEK100.compareTo(DKK));
	}
}
