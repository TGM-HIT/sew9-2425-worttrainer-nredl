import at.nredl.model.Wort;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WortTest {

    @Test
    void testConstructorValid() {
        Wort wort = new Wort("Hund", "http://example.com/hund.jpg");
        assertEquals("Hund", wort.getWort());
        assertEquals("http://example.com/hund.jpg", wort.getUrl());
    }

    @Test
    void testConstructorInvalidBezeichnung() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            new Wort("", "http://example.com/hund.jpg");
        });
        assertEquals("Die Bezeichnung vom Wort darf nicht leer sein.", thrown.getMessage());
    }

    @Test
    void testConstructorInvalidUrl() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            new Wort("Hund", "");
        });
        assertEquals("Die URL vom Wort darf nicht leer sein.", thrown.getMessage());
    }

    @Test
    void testSetValidBezeichnung() {
        Wort wort = new Wort("Hund", "http://example.com/hund.jpg");
        wort.setBezeichnung("Katze");
        assertEquals("Katze", wort.getWort());
    }

    @Test
    void testSetInvalidBezeichnung() {
        Wort wort = new Wort("Hund", "http://example.com/hund.jpg");
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            wort.setBezeichnung("");
        });
        assertEquals("Das Wort darf nicht leer sein.", thrown.getMessage());
    }

    @Test
    void testSetValidUrl() {
        Wort wort = new Wort("Hund", "http://example.com/hund.jpg");
        wort.setUrl("http://example.com/katze.jpg");
        assertEquals("http://example.com/katze.jpg", wort.getUrl());
    }

    @Test
    void testSetInvalidUrl() {
        Wort wort = new Wort("Hund", "http://example.com/hund.jpg");
        assertThrows(IllegalArgumentException.class, () -> {
            wort.setUrl("");
        });
    }

    @Test
    void testSetMalformedUrl() {
        Wort wort = new Wort("Hund", "http://example.com/hund.jpg");
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            wort.setUrl("invalid-url");
        });
        assertTrue(thrown.getMessage().contains("Die URL ist ungültig"));
    }
}