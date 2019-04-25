package com.example.hw3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void otherButton(View v){
        String text = "You clicked the " + v.getTag();
        Toast toast = Toast.makeText(getApplicationContext(), text,Toast.LENGTH_SHORT);
        toast.show();
        //Log.d(TAG, text + v.getTag());
    }

    public void topLeftButton(View v){
        Intent movies = new Intent(this, MoviesActivity.class);
        startActivity(movies);
    }

}
