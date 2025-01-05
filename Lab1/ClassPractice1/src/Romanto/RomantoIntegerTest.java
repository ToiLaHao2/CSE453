package Romanto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RomantoIntegerTest {
    RomantoInteger roman;

    @Test
    void singleDigit() {// fix bug in here
        roman = new RomantoInteger();
        int a = roman.convert("XIX");
        assertEquals(19, a);
    }
}
