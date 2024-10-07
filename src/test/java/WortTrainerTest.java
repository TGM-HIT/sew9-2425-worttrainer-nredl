import at.nredl.model.Wort;
import at.nredl.model.WortTrainer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class WortTrainerTest {

    private WortTrainer wortTrainer;

    @BeforeEach
    void setUp() {
        wortTrainer = new WortTrainer();
        List<Wort> wordList = new ArrayList<>();
        wordList.add(new Wort("Hund", "http://example.com/hund.jpg"));
        wordList.add(new Wort("Katze", "http://example.com/katze.jpg"));
        wortTrainer.setWordList(wordList);
    }

    @Test
    void testSetAndGetWordList() {
        List<Wort> newWordList = new ArrayList<>();
        newWordList.add(new Wort("Maus", "http://example.com/maus.jpg"));
        wortTrainer.setWordList(newWordList);
        assertEquals(1, wortTrainer.getWordList().size());
        assertEquals("Maus", wortTrainer.getWordList().get(0).getWort());
    }

    @Test
    void testSetEmptyWordListThrowsException() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            wortTrainer.setWordList(new ArrayList<>());
        });
        assertEquals("Wortliste darf nicht leer sein.", thrown.getMessage());
    }

    @Test
    void testGetCorrectGuessCount() {
        wortTrainer.setCorrectGuessCount(5);
        assertEquals(5, wortTrainer.getCorrectGuessCount());
    }

    @Test
    void testSetCorrectGuessCountInvalid() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            wortTrainer.setCorrectGuessCount(-1);
        });
        assertEquals("CorrectGuessCount darf nicht niedriger als 0 sein.", thrown.getMessage());
    }

    @Test
    void testCheckCorrectGuess() {
        wortTrainer.setListIndex(0);
        assertTrue(wortTrainer.check("Hund"));
        assertEquals(1, wortTrainer.getCorrectGuessCount());
        assertEquals(1, wortTrainer.getTotalGuessCount());
    }

    @Test
    void testCheckIncorrectGuess() {
        wortTrainer.setListIndex(0);
        assertFalse(wortTrainer.check("Katze"));
        assertEquals(0, wortTrainer.getCorrectGuessCount());
        assertEquals(1, wortTrainer.getTotalGuessCount());
    }

    @Test
    void testRandomWord() {
        Wort randomWord = wortTrainer.randomWord();
        assertNotNull(randomWord);
        assertTrue(wortTrainer.getWordList().contains(randomWord));
    }

    @Test
    void testSaveAndLoadSession() {
        wortTrainer.setListIndex(2);
        wortTrainer.save();
        wortTrainer.setListIndex(1);
        wortTrainer.load();
        assertEquals(2, wortTrainer.getListIndex());
    }

    @Test
    void testSetAndGetTotalGuessCount() {
        wortTrainer.setTotalGuessCount(3);
        assertEquals(3, wortTrainer.getTotalGuessCount());
    }

    @Test
    void testSetInvalidTotalGuessCount() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            wortTrainer.setTotalGuessCount(-1);
        });
        assertEquals("TotalGuessCount darf nicht niedriger als 0 sein.", thrown.getMessage());
    }
}