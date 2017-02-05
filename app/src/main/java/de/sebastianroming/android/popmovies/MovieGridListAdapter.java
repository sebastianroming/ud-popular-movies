package de.sebastianroming.android.popmovies;

/**
 * Copyright (c) 2017 Sebastian Roming
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MovieGridListAdapter extends ArrayAdapter<Movie> {

    /** ---------------------------------------------------------------------------------- **/
    public static class ViewHolder {

        public final ImageView vhImageView;
        public final TextView vhTitleView;

        public ViewHolder(View view) {
            vhImageView = (ImageView) view.findViewById(R.id.grid_item_image);
            vhTitleView = (TextView) view.findViewById(R.id.grid_item_title);
        }

    }

    /** ---------------------------------------------------------------------------------- **/
    public MovieGridListAdapter(Context context) {
        super(context, 0);
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

}
