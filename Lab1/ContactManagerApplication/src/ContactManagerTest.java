import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactManagerTest {
    @Test
    public void shouldCreateContact() {
        ContactManager contactManager = new ContactManager();
        contactManager.addContact("John", "Doe", "0123456789");
        assertFalse(contactManager.getAllContacts().isEmpty());
        assertEquals(1, contactManager.getAllContacts().size());
    }

    @Test
    public void shouldThrowRuntimeExceptionWhenFirstNameIsNull() {
        ContactManager contactManager = new ContactManager();
        assertThrows(RuntimeException.class, () -> {
            contactManager.addContact(null, "Doe", "0123456789");
        });
    }

    @Test
    public void shouldThrowRuntimeExceptionWhenLastNameIsNull() {
        ContactManager contactManager = new ContactManager();
        assertThrows(RuntimeException.class, () -> {
            contactManager.addContact("John", null, "0123456789");
        });
    }

    @Test
    public void shouldThrowRuntimeExceptionWhenPhoneNumberIsNull() {
        ContactManager contactManager = new ContactManager();
        assertThrows(RuntimeException.class, () -> {
            contactManager.addContact("John", "Doe", null);
        });
    }

    
}
