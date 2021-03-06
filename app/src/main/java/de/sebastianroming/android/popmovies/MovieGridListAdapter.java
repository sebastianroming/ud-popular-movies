package de.sebastianroming.android.popmovies;

/**
 * Copyright (c) 2017 Sebastian Roming
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieGridListAdapter extends BaseAdapter {

    private final Context mContext;
    private final LayoutInflater mInflater;

    private final Movie mLock = new Movie();

    private List<Movie> mObjects;


    /** ---------------------------------------------------------------------------------- **/
    public MovieGridListAdapter(Context context, List<Movie> movies) {
        mContext = context;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mObjects = movies;
    }

    /** ---------------------------------------------------------------------------------- **/
    public Context getContext() {
        return mContext;
    }

    /** ---------------------------------------------------------------------------------- **/
    public void add(Movie object) {
        synchronized (mLock) {
            mObjects.add(object);
        }
        notifyDataSetChanged();
    }

    /** ---------------------------------------------------------------------------------- **/
    public void clear() {
        synchronized (mLock) {
            mObjects.clear();
        }
        notifyDataSetChanged();
    }

    /** ---------------------------------------------------------------------------------- **/
    @Override
    public int getCount() {
        return mObjects.size();
    }

    /** ---------------------------------------------------------------------------------- **/
    @Override
    public Movie getItem(int position) {
        return mObjects.get(position);
    }

    /** ---------------------------------------------------------------------------------- **/
    @Override
    public long getItemId(int position) {
        return position;
    }

    /** ---------------------------------------------------------------------------------- **/
    public void setData(List<Movie> data) {
        clear();
        for (Movie movie : data) {
            add(movie);
        }
    }

    /** ---------------------------------------------------------------------------------- **/
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder viewHolder;

        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.list_item_movie, parent, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }

        final Movie movie = getItem(position);
        String sImageUrl = Config.TMBD_IMAGE_BASE_URL + Config.TMBD_IMAGE_GRID_SIZE + movie.getImage();

        viewHolder = (ViewHolder) view.getTag();

        Picasso.with(getContext()).load(sImageUrl).into(viewHolder.vhImageView);

        viewHolder.vhTitleView.setText(movie.getTitle());

        return view;
    }

    /** ---------------------------------------------------------------------------------- **/
    public static class ViewHolder {

        public final ImageView vhImageView;
        public final TextView vhTitleView;

        public ViewHolder(View view) {
            vhImageView = (ImageView) view.findViewById(R.id.grid_item_image);
            vhTitleView = (TextView) view.findViewById(R.id.grid_item_title);
        }

    }

}
