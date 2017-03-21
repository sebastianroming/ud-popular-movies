package de.sebastianroming.android.popmovies;

/**
 * Copyright (c) 2017 Sebastian Roming
 */

import org.json.JSONException;
import org.json.JSONObject;

public class Review {

    private String id;
    private String author;
    private String content;

    /** ---------------------------------------------------------------------------------- **/
    public Review() {

    }

    /** ---------------------------------------------------------------------------------- **/
    public Review(JSONObject trailer) throws JSONException {
        this.id         = trailer.getString("id");
        this.author     = trailer.getString("author");
        this.content    = trailer.getString("content");
    }

    /** ---------------------------------------------------------------------------------- **/
    public String getId() {
        return this.id;
    }

    /** ---------------------------------------------------------------------------------- **/
    public String getAuthor() {
        return this.author;
    }

    /** ---------------------------------------------------------------------------------- **/
    public String getContent() {
        return this.content;
    }

}
