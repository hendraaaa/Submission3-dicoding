package com.example.submission3;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {

    private int idMovie;
    private String titleMovie;
    private String descMovie;
    private String releaseDateMovie;
    private String PosterMovie;
    private String voteMovie;

    public String getVoteMovie() {
        return voteMovie;
    }

    public void setVoteMovie(String voteMovie) {
        this.voteMovie = voteMovie;
    }

    public String getPosterMovie() {
        return PosterMovie;
    }

    public void setPosterMovie(String posterMovie) {
        PosterMovie = posterMovie;
    }

    public Movie(Parcel in) {
        idMovie = in.readInt();
        titleMovie = in.readString();
        descMovie = in.readString();
        releaseDateMovie = in.readString();
        PosterMovie = in.readString();
        voteMovie = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public int getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(int idMovie) {
        this.idMovie = idMovie;
    }

    public String getTitleMovie() {
        return titleMovie;
    }

    public void setTitleMovie(String titleMovie) {
        this.titleMovie = titleMovie;
    }

    public String getDescMovie() {
        return descMovie;
    }

    public void setDescMovie(String descMovie) {
        this.descMovie = descMovie;
    }


    public String getReleaseDateMovie() {
        return releaseDateMovie;
    }

    public void setReleaseDateMovie(String releaseDateMovie) {
        this.releaseDateMovie = releaseDateMovie;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(idMovie);
        parcel.writeString(titleMovie);
        parcel.writeString(descMovie);
        parcel.writeString(releaseDateMovie);
        parcel.writeString(PosterMovie);
        parcel.writeString(voteMovie);
    }

    public Movie() {

    }
}
