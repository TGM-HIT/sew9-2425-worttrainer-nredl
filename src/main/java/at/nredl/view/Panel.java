package at.nredl.view;

import at.nredl.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Die Panel-Klasse
 * @author Nikolaus Redl
 * 06-10-2024
 */
public class Panel extends JPanel {
    private Controller controller;
    private JLabel correctGuess, totalGuess, img;
    private JTextField input;
    private JButton save, load;
    private String url;

    public Panel(Controller controller) throws MalformedURLException {
        this.controller = controller;
        this.url = controller.getUrl();

        this.setLayout(new BorderLayout());

        JPanel top = new JPanel();
        top.setLayout(new GridLayout(2,1));
        JLabel frage = new JLabel("Welches Wort wird dargestellt?");
        frage.setHorizontalAlignment(JLabel.LEFT);
        top.add(frage);
        this.input = new JTextField();
        top.add(input);
        this.add(top, BorderLayout.PAGE_START);

        JPanel center = new JPanel();
        center.setLayout(new GridLayout(1,1));
        Image image = new ImageIcon(new URL(this.url)).getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        this.img = new JLabel(new ImageIcon(image));
        center.add(img);
        this.add(center, BorderLayout.CENTER);

        JPanel bottom = new JPanel();
        bottom.setLayout(new GridLayout(3,2));
        JLabel textTotal = new JLabel("Gesamtversuche:");
        JLabel textCorrect = new JLabel("Richtige Versuche:");
        this.correctGuess = new JLabel(String.valueOf(this.controller.getCorrect()));
        this.totalGuess = new JLabel(String.valueOf(this.controller.getTotal()));
        bottom.add(textTotal);
        bottom.add(textCorrect);
        bottom.add(totalGuess);
        bottom.add(correctGuess);
        this.save = new JButton("Speichern");
        this.load = new JButton("Laden");
        bottom.add(save);
        bottom.add(load);

        this.add(bottom, BorderLayout.PAGE_END);

        this.input.addActionListener(this.controller);
        this.input.setActionCommand("input");
        this.save.addActionListener(this.controller);
        this.save.setActionCommand("save");
        this.load.addActionListener(this.controller);
        this.load.setActionCommand("load");

    }

    public String getInput() {
        return this.input.getText();
    }

    public void next(String url) throws MalformedURLException {
        this.input.setText("");
        this.totalGuess.setText(String.valueOf(this.controller.getTotal()));
        this.correctGuess.setText(String.valueOf(this.controller.getCorrect()));
        this.url = url;
        ImageIcon imageIcon = new ImageIcon(new URL(this.url));
        Image image = imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH);
        this.img = new JLabel(new ImageIcon(image));
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(1,1));
        center.add(img);
        this.add(center, BorderLayout.CENTER);
    }
}