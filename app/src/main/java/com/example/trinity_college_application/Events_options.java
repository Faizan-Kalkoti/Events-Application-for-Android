package com.example.trinity_college_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Events_options extends AppCompatActivity {

    Button Thisyrs, Previousyrs, upcoming;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_options);

        Thisyrs =findViewById(R.id.This);
        Previousyrs =findViewById(R.id.Previous);
        upcoming =findViewById(R.id.Upcoming_events);

        Thisyrs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Events_options.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Previousyrs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Events_options.this, Previous_yrs_events.class);
                startActivity(intent);
            }
        });

        upcoming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Events_options.this, Upcoming_events_activity.class);
                startActivity(intent);
            }
        });

    }
}