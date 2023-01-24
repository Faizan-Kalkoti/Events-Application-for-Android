package com.example.trinity_college_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class open_events extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_events);

        TextView tn1=findViewById(R.id.tn1);
        TextView tn2=findViewById(R.id.tn2);
        TextView tn3=findViewById(R.id.tn3);
        TextView tn4=findViewById(R.id.tn4);
        TextView tn5 =findViewById(R.id.tn5);

        String classes ="no events number!";
        String day ="no events number!";
        String description ="no events number!";
        String month ="no events number!";
        String name ="no events number!";
        String number ="no events number!";
        String year ="no event number!";


        Bundle extras = getIntent().getExtras();
        if (extras !=null )
        {
            classes=extras.getString("classes");
            day = extras.getString("day");
            description = extras.getString("description");
            month = extras.getString("month");
            name = extras.getString("name");
            number = extras.getString("number");
            year =extras.getString("year");

        }
        tn1.setText("Number: "+name);
        tn2.setText("Title: "+number);
        tn3.setText("Date: "+day+"-"+classes+"-"+year);
        tn4.setText("Class: "+month);
        tn5.setText(description);
    }
}