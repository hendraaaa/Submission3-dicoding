package com.example.submission3;

import android.os.Parcel;
import android.os.Parcelable;

public class TvShow implements Parcelable {
    private int idMovie;
    private String name;
    private String Tanggal;
    private String vote;
    private String desc;
    private String Gambar;

    protected TvShow(Parcel in) {
        idMovie = in.readInt();
        name = in.readString();
        Tanggal = in.readString();
        vote = in.readString();
        desc = in.readString();
        Gambar = in.readString();
    }

    public static final Creator<TvShow> CREATOR = new Creator<TvShow>() {
        @Override
        public TvShow createFromParcel(Parcel in) {
            return new TvShow(in);
        }

        @Override
        public TvShow[] newArray(int size) {
            return new TvShow[size];
        }
    };

    public int getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(int idMovie) {
        this.idMovie = idMovie;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTanggal() {
        return Tanggal;
    }

    public void setTanggal(String tanggal) {
        Tanggal = tanggal;
    }

    public String getVote() {
        return vote;
    }

    public void setVote(String vote) {
        this.vote = vote;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getGambar() {
        return Gambar;
    }

    public void setGambar(String gambar) {
        Gambar = gambar;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(idMovie);
        parcel.writeString(name);
        parcel.writeString(Tanggal);
        parcel.writeString(vote);
        parcel.writeString(desc);
        parcel.writeString(Gambar);
    }

    public TvShow() {

    }
}
