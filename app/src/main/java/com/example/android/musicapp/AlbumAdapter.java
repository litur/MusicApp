package com.example.android.musicapp;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.ArrayList;


/**
 * Created by RutiglianoL on 05/04/2018.
 */

public class AlbumAdapter extends ArrayAdapter<Album> {

    AlbumAdapter(Activity context, ArrayList<Album> Album) {

        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.

        super(context, 0, Album);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.grid_item_album, parent, false);
        }

        final int myAlbum;

        // Get the {@link Album} object located at this position in the list
        Album currentAlbum = getItem(position);

        // Find the ImageView in the grid_item_album.xml layout with the ID AlbumCoverImageView
        ImageView iconView = listItemView.findViewById(R.id.AlbumCoverImageView);
        // Get the image resource ID from the current Album object and
        // set the image to iconView
        assert currentAlbum != null;
        iconView.setImageResource(currentAlbum.getAlbumCoverID());

        myAlbum = currentAlbum.getID();

        // Set a click listener on that Album Image Button
        iconView.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the Album Image is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link AlbumDetailActivity}
                Intent albumDetailIntent = new Intent(getContext(), AlbumDetailActivity.class);
                albumDetailIntent.putExtra("AlbumID", myAlbum);
                getContext().startActivity(albumDetailIntent);
            }
        });

        // Return the whole list item layout
        // so that it can be shown in the GridView
        return listItemView;
    }

}
