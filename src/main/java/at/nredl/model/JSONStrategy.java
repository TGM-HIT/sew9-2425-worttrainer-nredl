package at.nredl.model;

/**
 * Das Interface für die Strategy
 * @author Nikolaus Redl
 * @version 06-10-2024
 */
public interface JSONStrategy {
    void saveSession(WortTrainer wortTrainer);
    void loadSession(WortTrainer wortTrainer);
}