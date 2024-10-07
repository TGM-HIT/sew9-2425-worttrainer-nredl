package at.nredl.controller;

import at.nredl.model.WortTrainer;
import at.nredl.view.Frame;
import at.nredl.view.Panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.util.Objects;

/**
 * Controller-Klasse
 * @author Nikolaus Redl
 * @version 06-10-2024
 */
public class Controller implements ActionListener {
    private WortTrainer wortTrainer;
    private Panel panel;
    private Frame frame;

    public Controller() {
        this.wortTrainer = new WortTrainer();
        try {
            this.panel = new Panel(this);
        } catch(MalformedURLException mue) {
            mue.printStackTrace();
        }
        this.frame = new Frame(this.panel);
    }

    public static void main(String[] args) {
        new Controller();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        if(Objects.equals(actionCommand, "save")) {
            this.wortTrainer.save();
        }
        else if (Objects.equals(actionCommand, "load")) {
            this.wortTrainer.load();
            try {
                this.panel.next(this.wortTrainer.getCurrentWord().getUrl());
            } catch (MalformedURLException ex) {
                throw new RuntimeException(ex);
            }
        }
        else if (Objects.equals(actionCommand, "input")) {
            this.wortTrainer.setTotalGuessCount(this.wortTrainer.getTotalGuessCount()+1);
            if(this.wortTrainer.check(this.panel.getInput())) {
                this.wortTrainer.setCorrectGuessCount(this.wortTrainer.getCorrectGuessCount()+1);
            }
            this.wortTrainer.newIndex();
            try {
                this.panel.next(this.wortTrainer.getCurrentWord().getUrl());
            } catch (MalformedURLException ex) {
                throw new RuntimeException(ex);
            }
        }
        else if(Objects.equals(actionCommand, "reset")) {
            this.wortTrainer.setCorrectGuessCount(0);
            this.wortTrainer.setTotalGuessCount(0);
            try {
                this.panel.next(this.wortTrainer.getCurrentWord().getUrl());
            } catch (MalformedURLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public int getCorrect() {
        return this.wortTrainer.getCorrectGuessCount();
    }

    public int getTotal() {
        return this.wortTrainer.getTotalGuessCount();
    }

    public String getUrl() {
        return this.wortTrainer.getCurrentWord().getUrl();
    }
}
