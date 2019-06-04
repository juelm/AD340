package com.example.hw6;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.ListView;

public class TrafficCamActivity extends AppCompatActivity {

    private TrafficCam[] cameras = new TrafficCam[1000];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        Intent intent = getIntent();
        //this.cameras = intent.getParcelableArrayExtra("cameraArray");

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        //ListView listview = (ListView) findViewById(R.id.listview);


        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        TrafficCamAdapter adapter = new TrafficCamAdapter(this,  this.cameras);
        //recyclerView.setAdapter(adapter);
        //listview.setAdapter(adapter);

    }

}
