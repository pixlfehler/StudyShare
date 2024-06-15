package com.pixldev.studyshare;

import android.os.Parcel;
import android.os.Parcelable;

public class Freundemodel {
    private String name;
    private String stufe;
    private int freunde_thumbnail;


    // Constructor
    public Freundemodel(String name, String stufe, int freunde_thumbnail) {
        this.name = name;
        this.stufe = stufe;
        this.freunde_thumbnail = freunde_thumbnail;
    }


    // Getter and Setter for author
    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    // Getter and Setter for content
    public String getstufe() {
        return stufe;
    }

    public void setstufe(String stufe) {
        this.stufe = stufe;
    }

    // Getter and Setter for bewertung
    public int getfreunde_thumbnail() {
        return freunde_thumbnail;
    }

    public void setfreunde_thumbnail(int freunde_thumbnail) {
        this.freunde_thumbnail = freunde_thumbnail;
    }

    // Parcelable implementation


}

