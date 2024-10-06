package at.nredl.model;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Klasse die ein Wort mit dem zugehörigen Bild mittels dessen URL darstellt.
 * @author Nikolaus Redl
 * @version 05-10-2024
 */
public class Wort {

    private String bezeichnung;
    private String url;

    public Wort(String bezeichnung, String url) {
        if(bezeichnung == null) {
            throw new IllegalArgumentException("Die Bezeichnung vom Wort darf nicht leer sein.");
        }
        if(url == null) {
            throw new IllegalArgumentException("Die URL vom Wort darf nicht leer sein.");
        }
        this.bezeichnung = bezeichnung;
        this.url = url;
    }

    public void setBezeichnung(String bezeichnung) {
        if(bezeichnung.isEmpty()) {
            throw new IllegalArgumentException("Das Wort darf nicht leer sein.");
        }
        this.bezeichnung = bezeichnung;
    }

    public String getWort() {
        return this.bezeichnung;
    }

    public void setUrl(String url) {
        if(url.isEmpty()) {
            throw new IllegalArgumentException("Die Url darf nicht leer sein.");
        }
        try {
            URL tempUrl = new URL(url);
            this.url = url;
        } catch (MalformedURLException mue) {
            mue.printStackTrace();
        }
    }

    public String getUrl() {
        return this.url;
    }
}