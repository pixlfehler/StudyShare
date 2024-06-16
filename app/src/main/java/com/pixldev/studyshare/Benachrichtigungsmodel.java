package com.pixldev.studyshare;

public class Benachrichtigungsmodel {
    private String artderbenachrichtigung;
    private String infotext;


    // Constructor
    public Benachrichtigungsmodel(String artderbenachrichtigung, String infotext) {
        this.artderbenachrichtigung = artderbenachrichtigung;
        this.infotext = infotext;
    }


    // Getter and Setter for author
    public String getartderbenachrichtigung() {
        return artderbenachrichtigung;
    }

    public void setartderbenachrichtigung(String artderbenachrichtigung) {
        this.artderbenachrichtigung = artderbenachrichtigung;
    }

    // Getter and Setter for content
    public String getinfotext() {
        return infotext;
    }

    public void setinfotext(String infotext) {
        this.infotext = infotext;
    }


    // Parcelable implementation


}

