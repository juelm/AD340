package com.example.hw1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView bio = new TextView(this);
        bio.setText("Hello! \n My name is Matt Juel.  I got interested in technology because there were a lot of problems" +
                " at my old job that I thought would be pretty easy to automate and/or improve with  a little bit of code. " +
                "I also felt like there were better ways to process and display the data we worked with than manually populating excel and ppt templates." +
                " My current interest is to learn the skills needed to develop a couple of apps that I have been thinking about.");
        setContentView(bio);

    }
}
