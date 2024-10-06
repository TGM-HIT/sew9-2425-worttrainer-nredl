package at.nredl.model;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasse die für das Handling und den I/O von JSON-Files zuständig ist.
 * @author Nikolaus Redl
 * @version 06-10-2024
 */
public class JSONHandler implements JSONStrategy {

    public JSONHandler() {

    }
    @Override
    public void saveSession(WortTrainer wortTrainer, String fileName) {
        JSONObject json = new JSONObject();
        json.put("current", wortTrainer.getListIndex());
        json.put("total", wortTrainer.getTotalGuessCount());
        json.put("correct", wortTrainer.getCorrectGuessCount());

        JSONArray wordsArray = new JSONArray();
        for (Wort wort : wortTrainer.getWordList()) {
            JSONObject wordJson = new JSONObject();
            wordJson.put("word", wort.getWort());
            wordJson.put("url", wort.getUrl());
            wordsArray.put(wordJson);
        }
        json.put("words", wordsArray);

        try (FileWriter file = new FileWriter(fileName)) {
            file.write(json.toString());
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }

    @Override
    public void loadSession(WortTrainer wortTrainer, String fileName) {
        try(FileReader reader = new FileReader(fileName)) {
            JSONObject json = new JSONObject(new JSONTokener(reader));
            int current = json.getInt("current");
            int total = json.getInt("total");
            int correct = json.getInt("correct");

            List<Wort> words = new ArrayList<>();
            JSONArray wordsArray = json.getJSONArray("words");
            for(int i = 0; i < wordsArray.length(); i++) {
                JSONObject wordJson = wordsArray.getJSONObject(i);
                String wort = wordJson.getString("word");
                String url = wordJson.getString("url");
                words.add(new Wort(wort, url));
            }

            wortTrainer.setListIndex(current);
            wortTrainer.setTotalGuessCount(total);
            wortTrainer.setCorrectGuessCount(correct);
            wortTrainer.setWordList(words);

        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }
}