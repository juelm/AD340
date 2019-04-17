package com.example.hw2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;
import android.util.Log;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "LISTEN UP ";
    public static final String MessageID = "Eddy";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClick(View button){
        Log.i(TAG,   " myButton clicked");
        EditText textBox = (EditText)findViewById(R.id.textbox);
        String message = textBox.getText().toString();
        Intent nextPage = new Intent(this, ActivityTwo.class);
        nextPage.putExtra(MessageID, message);
        startActivity(nextPage);
    }

}
