package com.example.multiscreen;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    private int colorResourceID;
    public WordAdapter(Activity context, ArrayList<Word> words,int color){
        super(context,0,words);
        this.colorResourceID = color;
    }
    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        Word currentWord = getItem(position);

        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);

        miwokTextView.setText(currentWord.getMiwokTranslation());

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);

        defaultTextView.setText(currentWord.getDefaultTranslation());
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

        if (currentWord.hasImage()) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(currentWord.getImageResourceID());
        }else {
            imageView.setVisibility(View.GONE);
        }

        LinearLayout textContainer = (LinearLayout) listItemView.findViewById(R.id.text_container);

        int color = ContextCompat.getColor(getContext(),colorResourceID);

        textContainer.setBackgroundColor(color );
        return listItemView;
    }

}
