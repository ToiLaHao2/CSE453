package Q1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonnalNumberTest {

	private PersonnalNumber pan;
	private PersonnalNumber pan1;

	@BeforeEach
	void setUp() throws Exception {
		pan = new PersonnalNumber("640823-3234");
		pan1 = new PersonnalNumber("020805-1235");
		pan.initializeMonth();
		pan1.initializeMonth();
	}

	@Test
	void TestCheckSumDegit() {
		assertEquals(4, pan.getCheckSum());
	}

	@Test
	void TestGetDate() {
		assertEquals("640823", pan.getDate());
	}

	@Test
	void TestGetYear() {
		assertEquals(1964, pan.getYear());
	}

	@Test
	void TestMonth() {
		assertEquals("August", pan.getMonth());
	}

	@Test
	void TestGetSex() {
		assertEquals("male", pan.getSex());
	}

	@Test
	void TestPANContructedAsPerTheRules() {
		assertDoesNotThrow(() -> new PersonnalNumber("640823-3234"));
	}

	@Test
	void TestThrowException() {
		assertThrows(Exception.class, () -> new PersonnalNumber("640823-1235"));
	}
}
