package com.example.hw2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;
import android.widget.TextView;

public class ActivityTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedState){
        super.onCreate(savedState);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.MessageID);

        setContentView(R.layout.activity_two);

        TextView label = (TextView) findViewById(R.id.page2Text);
        label.setText(message);


    }

}
