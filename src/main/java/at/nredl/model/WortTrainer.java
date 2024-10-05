package at.nredl.model;

import java.util.List;

public class WortTrainer {

    private List<Wort> wordList;
    private int listIndex;
    private int correctGuessCount;
    private int totalGuessCount;

    public WortTrainer() {

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


}
