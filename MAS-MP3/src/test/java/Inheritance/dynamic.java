package Inheritance;

import exceptions.AttributeConstraintViolationException;
import model.dynamicInheritance.Lucznik;
import model.dynamicInheritance.Piechur;
import model.dynamicInheritance.Wojownik;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class dynamic {

    @Test
    public void testLucznikConstructor() {
        Lucznik lucznik = new Lucznik("Skórzana zbroja", 50.0);
        assertNotNull(lucznik);
        assertEquals("Skórzana zbroja", lucznik.getZbroja());
        assertEquals(50.0, lucznik.getZasieg());
    }

    @Test
    public void testLucznikZasiegNegative() {
        assertThrows(AttributeConstraintViolationException.class, () -> {
            new Lucznik("Skórzana zbroja", -10.0);
        });
    }

    @Test
    public void testWojownikConstructor() {
        Wojownik wojownik = new Wojownik("Miedziana zbroja", "Miecz");
        assertNotNull(wojownik);
        assertEquals("Miedziana zbroja", wojownik.getZbroja());
        assertEquals("Miecz", wojownik.getRodzajOreza());
    }

    @Test
    public void testWojownikRodzajOrezaEmpty() {
        assertThrows(AttributeConstraintViolationException.class, () -> {
            new Wojownik("Miedziana zbroja", "");
        });
    }

    @Test
    public void createWojownikFromLucznik() {
        Lucznik lucznik = new Lucznik("Skórzana zbroja", 50.0);
        Wojownik wojownik = new Wojownik(lucznik, "Miecz");
        assertNotNull(wojownik);
        assertEquals("Skórzana zbroja", wojownik.getZbroja());
        assertEquals("Miecz", wojownik.getRodzajOreza());
    }

    @Test
    public void createLucznikFromWojownik() {
        Wojownik wojownik = new Wojownik("Skórzana zbroja", "Miecz");
        Lucznik lucznik = new Lucznik(wojownik, 50.0);
        assertNotNull(lucznik);
        assertEquals("Skórzana zbroja", lucznik.getZbroja());
        assertEquals(50.0, lucznik.getZasieg());
    }


}
