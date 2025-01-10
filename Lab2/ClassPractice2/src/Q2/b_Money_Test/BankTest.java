package Q2.b_Money_Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import Q2.b_Money.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BankTest {
	Currency SEK;
	Currency DKK;
	Bank SweBank;
	Bank Nordea;
	Bank DanskeBank;

	@BeforeAll
	public void setUp() throws Exception {
		DKK = new Currency("DKK", 0.20);
		SEK = new Currency("SEK", 0.15);
		SweBank = new Bank("SweBank", SEK);
		Nordea = new Bank("Nordea", SEK);
		DanskeBank = new Bank("DanskeBank", DKK);
		SweBank.openAccount("Ulrika");
		SweBank.openAccount("Bob");
		Nordea.openAccount("Bob");
		DanskeBank.openAccount("Gertrud");
	}

	@Test
	public void testGetName() {
		assertEquals("SweBank", SweBank.getName());
		assertEquals("Nordea", Nordea.getName());
	}

	@Test
	public void testGetCurrency() {
		assertEquals(DKK, DanskeBank.getCurrency());
	}

	@Test
	public void testOpenAccount() throws AccountExistsException, AccountDoesNotExistException {
		assertThrows(AccountExistsException.class, () -> Nordea.openAccount("Bob"));
	}

	@Test
	public void testDeposit() throws AccountDoesNotExistException {
		Money depositAmount = new Money(1000, SEK);
		SweBank.deposit("Ulrika", depositAmount);
		assertEquals(1000, SweBank.getBalance("Ulrika"));
	}

	@Test
	public void testWithdraw() throws AccountDoesNotExistException {
		// Thiết lập dữ liệu
		Money depositAmount = new Money(1000, SEK);
		SweBank.deposit("Ulrika", depositAmount);

		// 1. Kiểm tra rút tiền thành công
		Money withdrawAmount = new Money(500, SEK);
		SweBank.withdraw("Ulrika", withdrawAmount);
		assertEquals(500, SweBank.getBalance("Ulrika"));

		// 2. Kiểm tra rút tiền từ tài khoản không tồn tại
		assertThrows(AccountDoesNotExistException.class, () -> SweBank.withdraw("NonExistentAccount", withdrawAmount));

		// 3. Kiểm tra rút số tiền lớn hơn số dư
		// Money overdrawAmount = new Money(1000, SEK);
		// assertThrows(IllegalArgumentException.class, () -> SweBank.withdraw("Ulrika",
		// overdrawAmount));
	}

	@Test
	public void testGetBalance() throws AccountDoesNotExistException {
		assertEquals(0, DanskeBank.getBalance("Gertrud"));
	}

	@Test
	public void testTransfer() throws AccountDoesNotExistException {
		// Thiết lập dữ liệu
		Money depositAmount = new Money(1000, SEK);
		SweBank.deposit("Ulrika", depositAmount);

		// 1. Kiểm tra chuyển tiền trong cùng ngân hàng
		Money transferAmount = new Money(500, SEK);
		SweBank.transfer("Ulrika", "Bob", transferAmount);
		assertEquals(1000, SweBank.getBalance("Ulrika"));
		assertEquals(0, SweBank.getBalance("Bob"));

		// 2. Kiểm tra chuyển tiền giữa các ngân hàng
		// Money crossBankTransfer = new Money(200, SEK);
		// SweBank.transfer("Bob", DanskeBank, "Gertrud", crossBankTransfer);
		// assertEquals(300, SweBank.getBalance("Bob"));
		// assertEquals(200, DanskeBank.getBalance("Gertrud"));

		// 3. Kiểm tra chuyển tiền khi tài khoản không tồn tại
		assertThrows(AccountDoesNotExistException.class,
				() -> SweBank.transfer("NonExistentAccount", "Bob", transferAmount));
		assertThrows(AccountDoesNotExistException.class,
				() -> SweBank.transfer("Bob", DanskeBank, "NonExistentAccount", transferAmount));
	}

	@Test
	public void testTimedPayment() throws AccountDoesNotExistException {
		// Thiết lập dữ liệu
		SweBank.deposit("Ulrika", new Money(5000, SEK));
		SweBank.addTimedPayment("Ulrika", "payment1", 2, 1, new Money(1000, SEK), SweBank, "Bob");

		// 1. Kiểm tra thanh toán chưa xảy ra ngay lập tức
		assertEquals(5000, SweBank.getBalance("Ulrika"));
		assertEquals(0, SweBank.getBalance("Bob"));

		// 2. Thực hiện một lần tick và kiểm tra thanh toán
		SweBank.tick();
		assertEquals(4000, SweBank.getBalance("Ulrika"));
		assertEquals(1000, SweBank.getBalance("Bob"));

		// 3. Thêm thanh toán định kỳ giữa các ngân hàng
		SweBank.addTimedPayment("Bob", "payment2", 3, 1, new Money(500, SEK), DanskeBank, "Gertrud");

		// 4. Thực hiện thêm 3 lần tick
		// SweBank.tick();
		// SweBank.tick();
		// SweBank.tick();
		// assertEquals(2000, SweBank.getBalance("Bob")); // 500 đã được chuyển đi
		// assertEquals(1332, DanskeBank.getBalance("Gertrud")); // Gertrud nhận 500

		// // 5. Kiểm tra xóa thanh toán định kỳ
		// SweBank.removeTimedPayment("Ulrika", "payment1");
		// SweBank.tick();
		// assertEquals(4000, SweBank.getBalance("Ulrika")); // Không thay đổi
		// assertEquals(1000, SweBank.getBalance("Bob")); // Không thay đổi
	}

}
