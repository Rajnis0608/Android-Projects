package com.example.multiscreen;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class WordAdapter extends ArrayAdapter<Word> {
    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }

}
