package de.sebastianroming.android.popmovies;

/**
 * Copyright (c) 2017 Sebastian Roming
 */

import android.content.Context;
import android.database.Cursor;

public class Helper {

    /** ---------------------------------------------------------------------------------- **/
    public static int isMarkesAsFavorite(Context context, int id) {
        Cursor cursor = context.getContentResolver().query(
                MovieContract.MovieEntry.CONTENT_URI,
                null,
                MovieContract.MovieEntry.COLUMN_MOVIE_ID + " = ?",
                new String[] { Integer.toString(id) },
                null
        );
        int numRows = cursor.getCount();
        cursor.close();
        return numRows;
    }

}
