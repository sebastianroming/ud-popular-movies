package de.sebastianroming.android.popmovies;

/**
 * Copyright (c) 2017 Sebastian Roming
 */

public class Config {

    public static String TMBD_API_BASE_URL          = "http://api.themoviedb.org/3/movie/";
    public static String TMBD_API_SORT_POPULARITY   = "popular";
    public static String TMBD_API_SORT_RATING       = "top_rated";
    public static String TMBD_API_SORT_FAVORITE     = "favorite";
    public static String TMBD_API_ENDPOINT_REVIEWS  = "/reviews";
    public static String TMBD_API_ENDPOINT_VIDEOS   = "/videos";

    public static String TMBD_IMAGE_BASE_URL        = "http://image.tmdb.org/t/p/";
    public static String TMBD_IMAGE_GRID_SIZE       = "w185";
    public static String TMBD_IMAGE_DETAIL_SIZE     = "w342";

    public static String YOUTUBE_WATCH_URL          = "http://www.youtube.com/watch?v=";

    public static final String MOVIES_DATABASE_NAME = "popularmovies.db";
    public static final int MOVIES_DATABASE_VERSION = 1;

    public static final String[] MOVIE_COLUMNS      = {
            MovieContract.MovieEntry._ID,
            MovieContract.MovieEntry.COLUMN_MOVIE_ID,
            MovieContract.MovieEntry.COLUMN_TITLE,
            MovieContract.MovieEntry.COLUMN_IMAGE,
            MovieContract.MovieEntry.COLUMN_IMAGE2,
            MovieContract.MovieEntry.COLUMN_OVERVIEW,
            MovieContract.MovieEntry.COLUMN_RATING,
            MovieContract.MovieEntry.COLUMN_DATE
    };

    public static final int MOVIE_COLUMN_ID         = 0;
    public static final int MOVIE_COLUMN_MOVIE_ID   = 1;
    public static final int MOVIE_COLUMN_TITLE      = 2;
    public static final int MOVIE_COLUMN_IMAGE      = 3;
    public static final int MOVIE_COLUMN_DETAILIMAGE= 4;
    public static final int MOVIE_COLUMN_OVERVIEW   = 5;
    public static final int MOVIE_COLUMN_RATING     = 6;
    public static final int MOVIE_COLUMN_DATE       = 7;

}
