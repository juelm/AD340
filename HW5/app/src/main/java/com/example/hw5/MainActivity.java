package com.example.hw5;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.SearchView;


public class MainActivity extends AppCompatActivity {

    private Polygon poly;
    public String TAG = "MAIN ACTIVITY...";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Polygon initial = new Polygon(3,1, "inches");
        poly = initial;

        final RadioGroup radButtons = (RadioGroup)findViewById(R.id.radioGroup);

        final Button numSides = findViewById(R.id.button);
        numSides.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
               TextInputLayout numberSides = (TextInputLayout) findViewById(R.id.numberSides);
               String sidesString = numberSides.getEditText().getText().toString();



               if(sidesString.isEmpty()){
                   Toast sidesMessage = Toast.makeText(v.getContext(),"Sides Can't be Blank", Toast.LENGTH_SHORT);
                   sidesMessage.show();

               }else {
                   int numberGon = Integer.parseInt(sidesString);
                   int interiorAngle = poly.changeSides(numberGon);

                   TextView displayAngles = (TextView) findViewById(R.id.display_angles);
                   displayAngles.setText("Interior Angles: " + poly.getDegrees() + " Degrees");
                   //Log.d(TAG,"Sides: " + poly.getSides());
               }

            }
        });

        final Button lenSides = findViewById(R.id.button2);
        lenSides.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                TextInputLayout lengthSides = (TextInputLayout) findViewById(R.id.sideLengthInput);
                String lengthString = lengthSides.getEditText().getText().toString();


                if(lengthString.isEmpty()){
                    Toast lengthMessage = Toast.makeText(v.getContext(),"Length Can't be Blank", Toast.LENGTH_SHORT);
                    lengthMessage.show();
                }else {
                    int sideLength = Integer.parseInt(lengthString);
                    int radioCheck = radButtons.getCheckedRadioButtonId();
                    RadioButton checked = (RadioButton) findViewById(radioCheck);
                    String units = (String) checked.getText();
                    int perimeter = poly.changeLength(sideLength, units);
                    Toast lengthMessage = Toast.makeText(v.getContext(),"Length of Sides is now " + poly.getSideLength() + " " + poly.getUnits(), Toast.LENGTH_SHORT);
                    //lengthMessage.show();
                    TextView displayPerimeter = (TextView) findViewById(R.id.display_perimeter);
                    displayPerimeter.setText("Perimeter: " + poly.getPerimeter() + " " + poly.getUnits());
                }
            }
        });



    }


}
