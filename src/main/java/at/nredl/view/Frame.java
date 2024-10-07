package at.nredl.view;

import javax.swing.*;

/**
 * Die Frame-Klasse
 * @author Nikolaus Redl
 * @version 06-10-2024
 */
public class Frame extends JFrame {
    public Frame(JPanel jPanel) {
        super("Worttrainer");
        this.add(jPanel);
        this.setSize(540,540);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
