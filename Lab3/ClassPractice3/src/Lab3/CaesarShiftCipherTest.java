package Lab3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CaesarShiftCipherTest {

    @Test
    void testValidShiftPositive() {
        CaesarShiftCipher cipher = new CaesarShiftCipher();
        String message = "ATTACKATONCE";
        int shift = 4;
        String expected = "EXXEGOEXSRGI";
        assertEquals(expected, cipher.CaesarShift(message, shift));
    }

    @Test
    void testValidShiftNegative() {
        CaesarShiftCipher cipher = new CaesarShiftCipher();
        String message = "EXXEGOEXSRGI";
        int shift = -4;
        String expected = "ATTACKATONCE";
        assertEquals(expected, cipher.CaesarShift(message, shift));
    }

    @Test
    void testShiftWithWrapAroundPositive() {
        CaesarShiftCipher cipher = new CaesarShiftCipher();
        String message = "XYZ";
        int shift = 3;
        String expected = "ABC";
        assertEquals(expected, cipher.CaesarShift(message, shift));
    }

    @Test
    void testShiftWithWrapAroundNegative() {
        CaesarShiftCipher cipher = new CaesarShiftCipher();
        String message = "ABC";
        int shift = -3;
        String expected = "XYZ";
        assertEquals(expected, cipher.CaesarShift(message, shift));
    }

    @Test
    void testShiftWithZero() {
        CaesarShiftCipher cipher = new CaesarShiftCipher();
        String message = "HELLO";
        int shift = 0;
        String expected = "HELLO";
        assertEquals(expected, cipher.CaesarShift(message, shift));
    }

    @Test
    void testInvalidCharacterInMessage() {
        CaesarShiftCipher cipher = new CaesarShiftCipher();
        String message = "HELLO123";
        int shift = 4;
        String expected = "invalid";
        assertEquals(expected, cipher.CaesarShift(message, shift));
    }

    @Test
    void testEmptyMessage() {
        CaesarShiftCipher cipher = new CaesarShiftCipher();
        String message = "";
        int shift = 5;
        String expected = "";
        assertEquals(expected, cipher.CaesarShift(message, shift));
    }

    @Test
    void testFullAlphabetPositiveShift() {
        CaesarShiftCipher cipher = new CaesarShiftCipher();
        String message = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int shift = 3;
        String expected = "DEFGHIJKLMNOPQRSTUVWXYZABC";
        assertEquals(expected, cipher.CaesarShift(message, shift));
    }

    @Test
    void testFullAlphabetNegativeShift() {
        CaesarShiftCipher cipher = new CaesarShiftCipher();
        String message = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int shift = -3;
        String expected = "XYZABCDEFGHIJKLMNOPQRSTUVW";
        assertEquals(expected, cipher.CaesarShift(message, shift));
    }
}
