package de.sebastianroming.android.popmovies;

/**
 * Copyright (c) 2017 Sebastian Roming
 */

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;

public class Movie implements Parcelable {

    private int id;
    private String title;
    private String image;
    private String detailImage;
    private String overview;
    private int rating;
    private String date;

    /** ---------------------------------------------------------------------------------- **/
    public Movie() {

    }

    /** ---------------------------------------------------------------------------------- **/
    public Movie(JSONObject movie) throws JSONException {

        this.id         = movie.getInt("id");
        this.title      = movie.getString("original_title");
        this.image      = movie.getString("poster_path");
        this.detailImage= movie.getString("backdrop_path");
        this.overview   = movie.getString("overview");
        this.rating     = movie.getInt("vote_average");
        this.date       = movie.getString("release_date");

    }

    /** ---------------------------------------------------------------------------------- **/
    public Movie(Cursor cursor) {
        this.id         = cursor.getInt(Config.MOVIE_COLUMN_ID);
        this.title      = cursor.getString(Config.MOVIE_COLUMN_TITLE);
        this.image      = cursor.getString(Config.MOVIE_COLUMN_IMAGE);
        this.detailImage= cursor.getString(Config.MOVIE_COLUMN_DETAILIMAGE);
        this.overview   = cursor.getString(Config.MOVIE_COLUMN_OVERVIEW);
        this.rating     = cursor.getInt(Config.MOVIE_COLUMN_RATING);
        this.date       = cursor.getString(Config.MOVIE_COLUMN_DATE);
    }

    /** ---------------------------------------------------------------------------------- **/
    public int getId() {
        return id;
    }

    /** ---------------------------------------------------------------------------------- **/
    public String getTitle() {
        return title;
    }

    /** ---------------------------------------------------------------------------------- **/
    public String getImage() {
        return image;
    }

    /** ---------------------------------------------------------------------------------- **/
    public String getDetailImage() {
        return detailImage;
    }

    /** ---------------------------------------------------------------------------------- **/
    public String getOverview() {
        return overview;
    }

    /** ---------------------------------------------------------------------------------- **/
    public int getRating() {
        return rating;
    }

    /** ---------------------------------------------------------------------------------- **/
    public String getDate() {
        return date;
    }

    /** ---------------------------------------------------------------------------------- **/
    @Override
    public int describeContents() {
        return 0;
    }

    /** ---------------------------------------------------------------------------------- **/
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(image);
        dest.writeString(detailImage);
        dest.writeString(overview);
        dest.writeInt(rating);
        dest.writeString(date);
    }

    /** ---------------------------------------------------------------------------------- **/
    public static final Parcelable.Creator<Movie> CREATOR
            = new Parcelable.Creator<Movie>() {

        /** ---------------------------------------------------------------------------------- **/
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        /** ---------------------------------------------------------------------------------- **/
        public Movie[] newArray(int size) {
            return new Movie[size];
        }

    };

    /** ---------------------------------------------------------------------------------- **/
    private Movie(Parcel in) {
        id          = in.readInt();
        title       = in.readString();
        image       = in.readString();
        detailImage = in.readString();
        overview    = in.readString();
        rating      = in.readInt();
        date        = in.readString();
    }
}
