package com.example.trinity_college_application;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class Home_page extends AppCompatActivity {

    Button Eventbutton, Newsbutton;
    ImageButton Login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Eventbutton = findViewById(R.id.Events_btn);
        //Loginbutton = findViewById(R.id.Login_btn);
        Newsbutton = findViewById(R.id.news_btn);
        Login = findViewById(R.id.imageButton5);

        Eventbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_page.this, Events_options.class);
                startActivity(intent);
            }
        });

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_page.this, Login_page.class);
                startActivity(intent);
            }
        });

        Newsbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_page.this, News_activity.class);
                startActivity(intent);
            }
        });
    }
}
