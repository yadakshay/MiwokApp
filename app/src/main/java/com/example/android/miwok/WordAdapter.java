package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Akshay on 30-04-2017.
 */

public class WordAdapter extends ArrayAdapter<Word>{

    private int mSetColor;
  //  private static final String LOG_TAG = WordAdapter.class.getSimpleName();
    /**
     * This is custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context        The current context. Used to inflate the layout file.
     * @param wordArray      A List of eng word and corresponding miwok words objects to display in a list
     */
    public WordAdapter(Activity context, ArrayList<Word> wordArray, int setColor) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.

        super(context, 0, wordArray);
        mSetColor = setColor;
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID display_num_miwok
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.display_num_miwok);

        // Get the miwok word from the current Word object and
        // set this text on the name TextView
        miwokTextView.setText(currentWord.getMiwok_Word());

        // Find the TextView in the list_item.xml layout with the ID display_num_miwok
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.display_num);

        // Get the english word from the current Word object and
        // set this text on the name TextView
        defaultTextView.setText(currentWord.getDefault_word());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.imageDisplay);

        if (currentWord.isImagePresent())
        {
            imageView.setImageResource(currentWord.getmImageResourceId());
        }
        else {
            imageView.setVisibility(View.GONE);
        }

        // set color
        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), mSetColor);
        textContainer.setBackgroundColor(color);

        return listItemView;
    }

}
