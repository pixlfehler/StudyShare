package com.pixldev.studyshare;

public class Anfragenmodel {
    // Private Membervariablen für den Namen, die Stufe und das Thumbnail-Bild
    private String name;
    private String stufe;
    private int freunde_thumbnail;

    // Konstruktor
    public Anfragenmodel(String name, String stufe, int freunde_thumbnail) {
        this.name = name; // Initialisiert den Namen
        this.stufe = stufe; // Initialisiert die Stufe
        this.freunde_thumbnail = freunde_thumbnail; // Initialisiert das Thumbnail-Bild
    }

    // Getter-Methode für den Namen
    public String getnameanfarge() {
        return name;
    }

    // Setter-Methode für den Namen
    public void setnameanfarge(String name) {
        this.name = name;
    }

    // Getter-Methode für die Stufe
    public String getstufeanfarge() {
        return stufe;
    }

    // Setter-Methode für die Stufe
    public void setstufeanfarge(String stufe) {
        this.stufe = stufe;
    }

    // Getter-Methode für das Thumbnail-Bild
    public int getanfarge_thumbnail() {
        return freunde_thumbnail;
    }

    // Setter-Methode für das Thumbnail-Bild
    public void setanfarge_thumbnail(int freunde_thumbnail) {
        this.freunde_thumbnail = freunde_thumbnail;
    }
}
