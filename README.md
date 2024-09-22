# Worttrainer

Ein Rechtschreibtrainer, bei dem der Benutzer zu einem Bild das passende Wort eingeben muss. Die Eingabe wird mit der richtigen Schreibweise verglichen, und es wird eine entsprechende Rückmeldung angezeigt. Dieses Projekt wird mit Java und Gradle umgesetzt.

## Funktionen

- **Wort-Bild-Paare**: Zu jedem Bild (URL) gibt es ein zugehöriges Wort, das korrekt eingegeben werden muss.
- **Statistiken**: Der Trainer speichert, wie oft Wörter insgesamt, richtig oder falsch geraten wurden.
- **Persistenz**: Der Zustand des Trainers (inkl. Wort-Bild-Paare, Statistik und aktueller Auswahl) kann gespeichert und wiederhergestellt werden.
- **Zufällige Auswahl**: Wörter können zufällig oder gezielt zum Üben ausgewählt werden.
- **Grafische Oberfläche**: Eine einfache Benutzeroberfläche mit `JOptionPane` ermöglicht die Eingabe und gibt Feedback.

## Installation & Verwendung

1. Klone das Repository:
   ```bash
   git clone https://github.com/TGM-HIT/sew9-2425-worttrainer-nredl
