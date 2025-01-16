package Q2.b_Money_Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import Q2.b_Money.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AccountTest {
	Currency SEK, DKK;
	Bank Nordea;
	Bank DanskeBank;
	Bank SweBank;
	Account testAccount;

	@BeforeAll
	public void setUp() throws Exception {
		SEK = new Currency("SEK", 0.15);
		SweBank = new Bank("SweBank", SEK);
		SweBank.openAccount("Alice");
		testAccount = new Account("Hans", SEK);
		testAccount.deposit(new Money(10000000, SEK));
		SweBank.deposit("Alice", new Money(1000000, SEK));
	}

	@Test
	public void testAddRemoveTimedPayment() {
		// Thêm thanh toán định kỳ
		testAccount.addTimedPayment("payment1", 5, 2, new Money(1000, SEK), SweBank, "Alice");
		assert (testAccount.timedPaymentExists("payment1")); // Xác nhận đã thêm thành công

		// Xóa thanh toán định kỳ
		testAccount.removeTimedPayment("payment1");
		assert (!testAccount.timedPaymentExists("payment1")); // Xác nhận đã xóa thành công
	}

	@Test
	public void testTimedPayment() throws AccountDoesNotExistException {
		// Thêm thanh toán định kỳ
		testAccount.addTimedPayment("payment1", 2, 1, new Money(1000, SEK), SweBank, "Alice");

		// Tick lần 1: Thanh toán chưa xảy ra
		testAccount.tick();
		assertEquals(10000000, testAccount.getBalance().getAmount()); // Số dư không thay đổi
		assertEquals(1000000, SweBank.getBalance("Alice")); // Số dư không thay đổi

		// Tick lần 2: Thanh toán xảy ra
		testAccount.tick();
		assertEquals(9999000, testAccount.getBalance().getAmount()); // Số dư giảm 1000 SEK
		assertEquals(1001000, SweBank.getBalance("Alice")); // Alice nhận 1000 SEK

		// Tick lần 3: Thanh toán không xảy ra
		testAccount.tick();
		assertEquals(9999000, testAccount.getBalance().getAmount()); // Số dư không thay đổi
		assertEquals(1001000, SweBank.getBalance("Alice")); // Số dư không thay đổi
	}

	@Test
	public void testAddWithdraw() {
		// Nạp tiền
		testAccount.deposit(new Money(500000, SEK));
		assertEquals(10500000, testAccount.getBalance().getAmount()); // Số dư tăng thêm 500000 SEK

		// Rút tiền thành công
		testAccount.withdraw(new Money(1000000, SEK));
		assertEquals(9500000, testAccount.getBalance().getAmount()); // Số dư giảm 1000000 SEK

		// Rút tiền thất bại (số tiền vượt quá số dư)
		assertThrows(IllegalArgumentException.class, () -> testAccount.withdraw(new Money(20000000, SEK)));
		assertEquals(9500000, testAccount.getBalance().getAmount()); // Số dư không thay đổi
	}

	@Test
	public void testGetBalance() {
		// Số dư ban đầu
		assertEquals(10000000, testAccount.getBalance().getAmount());

		// Nạp tiền
		testAccount.deposit(new Money(1000000, SEK));
		assertEquals(11000000, testAccount.getBalance().getAmount()); // Số dư tăng

		// Rút tiền
		testAccount.withdraw(new Money(500000, SEK));
		assertEquals(10500000, testAccount.getBalance().getAmount()); // Số dư giảm
	}

}
