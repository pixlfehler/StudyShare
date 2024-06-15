package com.pixldev.studyshare;

public class Anfragenmodel {
    private String name;
    private String stufe;
    private int freunde_thumbnail;


    // Constructor
    public Anfragenmodel(String name, String stufe, int freunde_thumbnail) {
        this.name = name;
        this.stufe = stufe;
        this.freunde_thumbnail = freunde_thumbnail;
    }


    // Getter and Setter for author
    public String getnameanfarge() {
        return name;
    }

    public void setnameanfarge(String name) {
        this.name = name;
    }

    // Getter and Setter for content
    public String getstufeanfarge() {
        return stufe;
    }

    public void setstufeanfarge(String stufe) {
        this.stufe = stufe;
    }

    // Getter and Setter for bewertung
    public int getanfarge_thumbnail() {
        return freunde_thumbnail;
    }

    public void setanfarge_thumbnail(int freunde_thumbnail) {
        this.freunde_thumbnail = freunde_thumbnail;
    }

    // Parcelable implementation


}

