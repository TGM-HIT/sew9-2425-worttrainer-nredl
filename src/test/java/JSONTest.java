import at.nredl.model.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JSONTest {
    private WortTrainer wortTrainer;
    private JSONHandler jsonHandler;
    private final String testFileName = "testSession.json";

    @BeforeEach
    void setUp() {
        wortTrainer = new WortTrainer();
        jsonHandler = new JSONHandler();

        List<Wort> wordList = new ArrayList<>();
        wordList.add(new Wort("Haus", "https://example.com/haus.jpg"));
        wordList.add(new Wort("Baum", "https://example.com/baum.jpg"));
        wortTrainer.setWordList(wordList);

        wortTrainer.setCorrectGuessCount(3);
        wortTrainer.setTotalGuessCount(5);
        wortTrainer.setListIndex(1);
    }

    @Test
    void testSaveSession() {
        jsonHandler.saveSession(wortTrainer);

        File file = new File(testFileName);
        assertTrue(file.exists(), "Die JSON-Datei wurde nicht erstellt.");
    }

    @Test
    void testLoadSession() {
        jsonHandler.saveSession(wortTrainer);
        WortTrainer loadedTrainer = new WortTrainer();
        jsonHandler.loadSession(loadedTrainer);

        assertEquals(wortTrainer.getListIndex(), loadedTrainer.getListIndex());
        assertEquals(wortTrainer.getCorrectGuessCount(), loadedTrainer.getCorrectGuessCount());
        assertEquals(wortTrainer.getTotalGuessCount(), loadedTrainer.getTotalGuessCount());

        List<Wort> originalWords = wortTrainer.getWordList();
        List<Wort> loadedWords = loadedTrainer.getWordList();

        assertEquals(originalWords.size(), loadedWords.size());
        for (int i = 0; i < originalWords.size(); i++) {
            assertEquals(originalWords.get(i).getBezeichnung(), loadedWords.get(i).getBezeichnung());
            assertEquals(originalWords.get(i).getUrl(), loadedWords.get(i).getUrl());
        }
    }
}
