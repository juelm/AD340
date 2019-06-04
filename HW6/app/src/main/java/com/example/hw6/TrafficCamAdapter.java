package com.example.hw6;

import android.content.Context;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class TrafficCamAdapter extends ArrayAdapter<TrafficCam> {

    private final Context context;
    private final TrafficCam[] camArray;


    public TrafficCamAdapter(Context context, TrafficCam[] cameras){
        super(context,-1, cameras);
        this.context = context;
        this.camArray = cameras;
    }

    public View getView(int position, View convertView, ViewGroup parent ){

        LinearLayout layout = new LinearLayout(context);
        layout.setOrientation(LinearLayout.VERTICAL);

        TextView description = new TextView(context);
        description.setText(camArray[position].getDescription());


        ImageView imageView = new ImageView(context);
        Picasso.with(context).load(camArray[position].getImageURL()).into(imageView);



        layout.addView(description);
        layout.addView(imageView);

        return layout;

    }

}
