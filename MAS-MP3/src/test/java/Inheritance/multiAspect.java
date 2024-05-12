package Inheritance;

import enums.Magic;
import model.multiAspectInheritance.Kostur;
import model.multiAspectInheritance.Rozdzka;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class multiAspect {

    @Test
    public void testKosturCreation() {
        Kostur kostur = new Kostur("Harry", "Potter", Magic.ZYWIOLOW, "Ogien", 5.0);
        assertNotNull(kostur);
        assertEquals("Harry", kostur.getImie());
        assertEquals("Potter", kostur.getNazwisko());
        assertEquals(Magic.ZYWIOLOW, kostur.getMagia());
        assertEquals("Ogien", kostur.getZywiol());
        assertEquals(5.0, kostur.getPoziomWzmocnieniaSilyZaklec());
    }

    @Test
    public void testKosturNegativePowerLevel() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Kostur("Hermione", "Granger", Magic.RUN, "Runa Mocy", -10.0);
        });
    }

    @Test
    public void testRozdzkaCreation() {
        Rozdzka rozdzka = new Rozdzka("Gandalf", "Szary", Magic.RUN, "Runa Mocy", 3.0);
        assertNotNull(rozdzka);
        assertEquals("Gandalf", rozdzka.getImie());
        assertEquals("Szary", rozdzka.getNazwisko());
        assertEquals(Magic.RUN, rozdzka.getMagia());
        assertEquals("Runa Mocy", rozdzka.getRuna());
        assertEquals(3.0, rozdzka.getPoziomPrzyspieszeniaRzucaniaZaklec());
    }

    @Test
    public void testRozdzkaNegativeAccelerationLevel() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Rozdzka("Dumbledore", "Albus", Magic.ZYWIOLOW, "Ogien", -7.5);
        });
    }

}
