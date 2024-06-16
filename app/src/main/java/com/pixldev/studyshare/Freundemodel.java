package com.pixldev.studyshare;

import android.os.Parcel;
import android.os.Parcelable;

public class Freundemodel {
    private String name;

    private String username;

    private int friendCount;

    private String stufe;
    private int freunde_thumbnail;


    // Constructor
    public Freundemodel(String name, String username, String stufe, int friendCount, int freunde_thumbnail) {
        this.name = name;
        this.stufe = stufe;
        this.freunde_thumbnail = freunde_thumbnail;
        this.username=username;
        this.stufe=stufe;
        this.friendCount=friendCount;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getFriendCount() {
        return friendCount;
    }

    public void setFriendCount(int friendCount) {
        this.friendCount = friendCount;
    }

    // Parcelable implementation


}

