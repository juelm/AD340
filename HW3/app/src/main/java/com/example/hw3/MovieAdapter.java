package com.example.hw3;

import android.widget.ArrayAdapter;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Collections;

public class MovieAdapter extends ArrayAdapter<String[]> {

    private final Context context;
    private final String[][] movieData;


    public MovieAdapter(Context context, String[][] values){
        super(context,-1, values);
        this.context = context;
        this.movieData = values;
    }

    public View getView(int position, View convertView, ViewGroup parent ){

        LinearLayout layout = new LinearLayout(context);
        layout.setOrientation(LinearLayout.VERTICAL);

        TextView title = new TextView(context);
        title.setText(movieData[position][0]);

        TextView year = new TextView(context);
        year.setText(movieData[position][1]);
        year.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_END);


        layout.addView(title);
        layout.addView(year);

        return layout;

    }







}
