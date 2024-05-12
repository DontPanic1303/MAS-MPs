package Inheritance;

import exceptions.AttributeConstraintViolationException;
import model.multiInheritance.Smartfon;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class multi {

    @Test
    public void testSmartfonCreation() {
        Smartfon smartfon = new Smartfon(100, "Model A", 999.99);
        assertNotNull(smartfon);
        assertEquals(100, smartfon.getIloscPiosenek());
        assertEquals("Model A", smartfon.getModel());
        assertEquals(999.99, smartfon.getCena());
    }

    @Test
    public void testSmartfonNegativePrice() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Smartfon(50, "Model B", -100.0);
        });
    }

    @Test
    public void testSmartfonZeroSongs() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Smartfon(0, "Model C", 199.99);
        });
    }

    @Test
    public void testSmartfonNullModel() {
        assertThrows(AttributeConstraintViolationException.class, () -> {
            new Smartfon(200, null, 299.99);
        });
    }

    @Test
    public void testSmartfonEmptyModel() {
        assertThrows(AttributeConstraintViolationException.class, () -> {
            new Smartfon(300, "", 399.99);
        });
    }

}
