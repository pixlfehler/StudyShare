package com.pixldev.studyshare;

import android.os.Parcel;
import android.os.Parcelable;

public class KommentarModel implements Parcelable {
    private String author;
    private String content;
    private Integer bewertung;

    // Constructor
    public KommentarModel(String author, String content, Integer bewertung) {
        this.author = author;
        this.content = content;
        this.bewertung = bewertung;
    }

    public KommentarModel(String author, String content) {
        this.author = author;
        this.content = content;
        this.bewertung = null;
    }

    // Getter and Setter for author
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // Getter and Setter for content
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    // Getter and Setter for bewertung
    public Integer getBewertung() {
        return bewertung;
    }

    public void setBewertung(Integer bewertung) {
        this.bewertung = bewertung;
    }

    // Parcelable implementation
    protected KommentarModel(Parcel in) {
        author = in.readString();
        content = in.readString();
        if (in.readByte() == 0) {
            bewertung = null;
        } else {
            bewertung = in.readInt();
        }
    }

    public static final Creator<KommentarModel> CREATOR = new Creator<KommentarModel>() {
        @Override
        public KommentarModel createFromParcel(Parcel in) {
            return new KommentarModel(in);
        }

        @Override
        public KommentarModel[] newArray(int size) {
            return new KommentarModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(author);
        dest.writeString(content);
        if (bewertung == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(bewertung);
        }
    }
}
