package com.example.hw3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.util.Log;
import android.content.Intent;

public class MoviesActivity extends AppCompatActivity {

    private String[][] movieData;
    public String TAG = "Movies!!!   ";
    public static final String messageID = "Movie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        this.movieData = MovieData.getMovies();
        MovieAdapter adapter = new MovieAdapter(this, this.movieData);

        ListView listview = (ListView) findViewById(R.id.listview);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String[] movie = movieData[position];
                String message = "Title: " + movie[0] + "\n" + "Year: " + movie[1] + "\n" +
                        "Director: " + movie[2] + "\n\n" + "Synopsis: " + movie[4] + "\n";
                Intent synopsis = new Intent(getApplicationContext(), SynopsisActivity.class);
                synopsis.putExtra(messageID, message);
                startActivity(synopsis);
                //Log.i(TAG, "You picked " + movie[0]);
            }
        });

    }

}
