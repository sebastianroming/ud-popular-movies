package de.sebastianroming.android.popmovies;

/**
 * Copyright (c) 2017 Sebastian Roming
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DetailActivityFragment extends Fragment {

    static final String DETAIL_MOVIE = "DETAIL_MOVIE";

    private Movie mMovie;

    private ImageView mImageView;
    private ImageView mPosterImageView;
    private TextView mTitleTextView;
    private TextView mOverviewTextView;
    private TextView mDateTextView;
    private TextView mVoteAverageTextView;

    /** ---------------------------------------------------------------------------------- **/
    public DetailActivityFragment() {
    }

    /** ---------------------------------------------------------------------------------- **/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Bundle arguments = getArguments();
        if (arguments != null) {
            mMovie = arguments.getParcelable(DetailActivityFragment.DETAIL_MOVIE);
        }

        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);

        mImageView              = (ImageView) rootView.findViewById(R.id.detail_image);
        mPosterImageView        = (ImageView) rootView.findViewById(R.id.detail_poster_image);
        mTitleTextView          = (TextView) rootView.findViewById(R.id.detail_title);
        mOverviewTextView       = (TextView) rootView.findViewById(R.id.detail_overview);
        mDateTextView           = (TextView) rootView.findViewById(R.id.detail_date);
        mVoteAverageTextView    = (TextView) rootView.findViewById(R.id.detail_vote_average);

        String sImageUrl = Config.TMBD_IMAGE_BASE_URL + Config.TMBD_IMAGE_DETAIL_SIZE + mMovie.getDetailImage();
        String sPosterImageUrl = Config.TMBD_IMAGE_BASE_URL + Config.TMBD_IMAGE_GRID_SIZE + mMovie.getImage();

        Picasso.with(getContext()).load(sImageUrl).into(mImageView);
        Picasso.with(getContext()).load(sPosterImageUrl).into(mPosterImageView);

        mTitleTextView.setText(mMovie.getTitle());
        mOverviewTextView.setText(mMovie.getOverview());

        String movie_date = mMovie.getDate();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            String date = DateUtils.formatDateTime(getActivity(),
                    formatter.parse(movie_date).getTime(), DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_YEAR);
            mDateTextView.setText(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        mVoteAverageTextView.setText(Integer.toString(mMovie.getRating()));

        return rootView;
    }
}
