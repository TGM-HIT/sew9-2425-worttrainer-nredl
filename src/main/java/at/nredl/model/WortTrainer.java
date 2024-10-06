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

    public WortTrainer() {
        this.wordList = new ArrayList<>();
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
       totalGuessCount++;
       boolean b = input.equalsIgnoreCase(currentWord().getWort());
       if(b) {
           correctGuessCount++;
       }
       return b;
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

    public Wort randomWord() {
        if(wordList.isEmpty()) {
            throw new IllegalArgumentException("Die Wortliste darf nicht leer sein wenn Sie ein zufälliges Wort wollen.");
        }
        return wordList.get(new Random().nextInt(wordList.size()));
    }
}