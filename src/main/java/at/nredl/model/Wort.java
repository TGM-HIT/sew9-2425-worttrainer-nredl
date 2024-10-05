package at.nredl.model;

import java.net.MalformedURLException;
import java.net.URL;

public class Wort {

    private String bezeichnung;
    private String url;

    public Wort(String bezeichnung, String url) {

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