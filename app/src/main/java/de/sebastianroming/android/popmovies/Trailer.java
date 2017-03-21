package de.sebastianroming.android.popmovies;

/**
 * Copyright (c) 2017 Sebastian Roming
 */

import org.json.JSONException;
import org.json.JSONObject;

public class Trailer {

    private String id;
    private String key;
    private String name;
    private String site;
    private String type;

    /** ---------------------------------------------------------------------------------- **/
    public Trailer() {

    }

    /** ---------------------------------------------------------------------------------- **/
    public Trailer(JSONObject trailer) throws JSONException {
        this.id     = trailer.getString("id");
        this.key    = trailer.getString("key");
        this.name   = trailer.getString("name");
        this.site   = trailer.getString("site");
        this.type   = trailer.getString("type");
    }

    /** ---------------------------------------------------------------------------------- **/
    public String getId() {
        return id;
    }

    /** ---------------------------------------------------------------------------------- **/
    public String getKey() {
        return this.key;
    }

    /** ---------------------------------------------------------------------------------- **/
    public String getName() {
        return this.name;
    }

    /** ---------------------------------------------------------------------------------- **/
    public String getSite() {
        return this.site;
    }

    /** ---------------------------------------------------------------------------------- **/
    public String getType() {
        return this.type;
    }

}
