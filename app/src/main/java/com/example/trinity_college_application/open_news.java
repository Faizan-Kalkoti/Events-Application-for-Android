package com.example.trinity_college_application;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class open_news extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.open_news);

       TextView tn1= findViewById(R.id.tn1);
       TextView tn2=findViewById(R.id.tn2);
       TextView  tn3=findViewById(R.id.tn3);
       TextView tn4=findViewById(R.id.tn4);

       String date ="no news number!";
       String description ="no news number!";
       String name ="no news number!";
       String number ="no news number!";


       Bundle extras = getIntent().getExtras();
       if (extras !=null )
       {
           date = extras.getString("date");
           description = extras.getString("description");
           name = extras.getString("name");
           number = extras.getString("number");
       }
       tn1.setText("Number: "+number);
       tn2.setText("Title: "+name);
       tn3.setText("Date: "+date);
       tn4.setText(description);


    }
}
