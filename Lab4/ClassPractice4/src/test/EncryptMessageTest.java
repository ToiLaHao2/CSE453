package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.EncryptMessage;

public class EncryptMessageTest {
    private EncryptMessage encryptor;

    @BeforeEach
    public void setUp() {
        encryptor = new EncryptMessage();
    }

    @Test
    public void testValidEvenLengthMessage() {
        String message = "abcdef";
        String expected = "yzwxuv";
        assertEquals(expected, encryptor.Encryption(message));  
    }

    @Test
    public void testValidOddLengthMessage() {
        String message = "abcde";
        String expected = "yzwxv"; 
        assertEquals(expected, encryptor.Encryption(message));
    }

    @Test
    public void testSingleCharacterMessage() {
        String message = "a";
        assertEquals("z", encryptor.Encryption(message)); 
    }

    @Test
    public void testMessageWithInvalidCharacters() {
        String message = "abc123";
        String expected = "invalid"; 
        assertEquals(expected, encryptor.Encryption(message)); 
    }

    @Test
    public void testEmptyMessage() {
        String message = "";
        String expected = "";  
        assertEquals(expected, encryptor.Encryption(message)); 
    }
    
    @Test
    public void testOutOfRange() {
        String message = "ļ";
        String expected = "invalid";  
        assertEquals(expected, encryptor.Encryption(message)); 
    }
}
