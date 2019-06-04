package com.example.hw6;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

public class TrafficCamRecyclerAdapter extends RecyclerView.Adapter<TrafficCamRecyclerAdapter.ViewHolder> {

    private final TrafficCam[] camArray;
    private final String TAG = "HEEELLLOOO from TCRA";



    public static class ViewHolder extends RecyclerView.ViewHolder{
        private CardView layout;
        private final String TAG = "HEEELLLOOO from VH";


        public ViewHolder(CardView v){
            super(v);
            layout = v;
            Log.d(TAG, "OK");

        }
    }

    public TrafficCamRecyclerAdapter(TrafficCam[] camArray){

        this.camArray = camArray;
        Log.d(TAG, "And" + camArray.length);
    }

    @NonNull
    @Override
    public TrafficCamRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        CardView cardview = (CardView) LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.traffic_cam_recyclerview_card, viewGroup,false);

//        TextView textView = (TextView) LayoutInflater.from(viewGroup.getContext())
//                .inflate(R.id.textview, viewGroup, false);

        return new ViewHolder(cardview);
    }

    @Override
    public void onBindViewHolder(@NonNull TrafficCamRecyclerAdapter.ViewHolder viewHolder, int i) {
        CardView cardView = viewHolder.layout;
        TextView description = (TextView) cardView.findViewById(R.id.description);
        ImageView image = (ImageView) cardView.findViewById(R.id.camera_image);
        Context context = cardView.getContext();

        TrafficCam cam = camArray[i];
        description.setText(cam.getDescription());
        Picasso.with(context).load(cam.getImageURL()).into(image);
    }

    @Override
    public int getItemCount() {
        return this.camArray.length;
    }

}
