package at.nredl.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Klasse die den Worttrainer, dessen Logik und Attribute verwaltet.
 * @author Nikolaus Redl
 * @version 05-10-2024
 */
public class WortTrainer {

    private List<Wort> wordList;
    private int listIndex;
    private int correctGuessCount;
    private int totalGuessCount;

    private JSONStrategy jsonHandler = new JSONHandler();

    public WortTrainer() {
        this.wordList = new ArrayList<>();
        this.jsonHandler.loadSession(this);
        this.totalGuessCount = 0;
        this.correctGuessCount = 0;
        this.setListIndex(0);
    }

    public void setWordList(List<Wort> wordList) {
        if(wordList.isEmpty()) {
            throw new IllegalArgumentException("Wortliste darf nicht leer sein.");
        }
        this.wordList = wordList;
    }

    public List<Wort> getWordList() {
        return this.wordList;
    }

    public void setCorrectGuessCount(int correctGuessCount) {
        if(correctGuessCount < 0) {
            throw new IllegalArgumentException("CorrectGuessCount darf nicht niedriger als 0 sein.");
        }
        this.correctGuessCount = correctGuessCount;
    }
    public int getCorrectGuessCount() {
        return this.correctGuessCount;
    }

    public void setTotalGuessCount(int totalGuessCount) {
        if(totalGuessCount < 0) {
            throw new IllegalArgumentException("TotalGuessCount darf nicht niedriger als 0 sein.");
        }
        this.totalGuessCount = totalGuessCount;
    }

    public int getTotalGuessCount() {
        return this.totalGuessCount;
    }

    public Wort currentWord() {
        return wordList.get(listIndex);
    }

    public boolean check(String input) {
       return input.equalsIgnoreCase(currentWord().getBezeichnung());
    }

    public void setListIndex(int listIndex) {
        if(listIndex < 0) {
            throw new IllegalArgumentException("Der aktuelle listIndex darf nicht kleiner als 0 sein.");
        }
        this.listIndex = listIndex;
    }

    public int getListIndex() {
        return this.listIndex;
    }

    public void save() {
        this.jsonHandler.saveSession(this);
    }

    public void load() {
        this.jsonHandler.loadSession(this);
    }

    public Wort getCurrentWord() {
        return this.wordList.get(this.listIndex);
    }

    public void newIndex() {
        this.listIndex = new Random().nextInt(wordList.size());
    }
}