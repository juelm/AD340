package com.example.hw6;

import android.content.Context;
import android.net.Network;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;

public class TrafficCamAsyncTaskLoader extends AsyncTaskLoader<String> {


    private String queryString;


    public TrafficCamAsyncTaskLoader(Context context, String queryString){

        super(context);
        this.queryString = queryString;

    }

    @Nullable
    @Override
    public String loadInBackground() {

        String baseURL = "https://web6.seattle.gov/Travelers/api/Map/Data?zoomId=13&type=2";

        return NetworkConnection.getData(baseURL);
    }

    @Override
    protected void onStartLoading(){
        forceLoad();
    }
}
