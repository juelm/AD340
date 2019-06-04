package com.example.hw6;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Iterator;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, LoaderManager.LoaderCallbacks<String> {

    private TextView results;
    private TrafficCam[] cameras = new TrafficCam[1000];
    private final static String TAG = "MAIN ACTIVITY...";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        Button button = findViewById(R.id.btn_get_data);
        button.setOnClickListener(this);

    }

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int i, @Nullable Bundle bundle) {

        String queryString = "";
        if(bundle != null){
            queryString = bundle.getString("queryString");
        }

        return new TrafficCamAsyncTaskLoader(this, queryString);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String s) {

        //cameras = new TrafficCam[1000];
        int camIndex = 0;
        try{

            JSONObject rootObject = new JSONObject(s);
            JSONArray data = rootObject.getJSONArray("Features");

            for(int i = 0; i < data.length(); i++){
                JSONArray cam = data.getJSONObject(i).getJSONArray("Cameras");
                for(int j = 0; j < cam.length(); j++){
                    //Log.d(TAG, ((JSONObject) cam.getJSONObject(j)).toString());
                    //Log.d(TAG, cam.getJSONObject(j).getString("Type"));
                    String x = cam.getJSONObject(j).getString("Type");


                    if(cam.getJSONObject(j).getString("Type").equals("sdot")) {
                        String fullURL = "http://www.seattle.gov/trafficcams/images/" + cam.getJSONObject(j).getString("ImageUrl");
                        cameras[camIndex] = new TrafficCam(cam.getJSONObject(j).getString("Id"),
                                cam.getJSONObject(j).getString("Description"), fullURL,
                                cam.getJSONObject(j).getString("Type"));

                        //Log.d(TAG, cameras[camIndex].getImageURL() );
                    }

                    if(cam.getJSONObject(j).getString("Type").equals("wsdot")) {
                        String fullURL = "http://images.wsdot.wa.gov/nw/" + cam.getJSONObject(j).getString("ImageUrl");
                        cameras[camIndex] = new TrafficCam(cam.getJSONObject(j).getString("Id"),
                                cam.getJSONObject(j).getString("Description"), fullURL,
                                cam.getJSONObject(j).getString("Type"));
                        //Log.d(TAG, cameras[camIndex].getImageURL());
                    }

                    camIndex++;
                }

            }

        }catch(Exception e){
            Log.e(TAG, e.getLocalizedMessage());
        }

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        ListView listview = (ListView) findViewById(R.id.listview);


        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        TrafficCamRecyclerAdapter adapter = new TrafficCamRecyclerAdapter(cameras);
        recyclerView.setAdapter(adapter);

//        TrafficCamAdapter adapter = new TrafficCamAdapter(this, cameras);
//        listview.setAdapter(adapter);

//        Intent trafficCamIntent = new Intent(getApplicationContext(), TrafficCamActivity.class);
//        trafficCamIntent.putExtra("cameraArray", cameras);
//        startActivity(trafficCamIntent);

    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }

    @Override
    public void onClick(View v) {

        ConnectivityManager manager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();

        if(info != null && info.isConnected()) {
            Bundle bundle = new Bundle();
            bundle.putString("queryString", "Data");
            getSupportLoaderManager().restartLoader(0, bundle, this);
        }else{
            results.setText("No Connection!");
        }
    }
}
