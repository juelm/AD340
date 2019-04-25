package com.example.hw3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.content.Intent;

public class SynopsisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView description = new TextView(this);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MoviesActivity.messageID);
        description.setText(message);
        setContentView(description);
    }
}
