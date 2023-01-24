package com.example.trinity_college_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.widget.Toast;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;


public class Admin_options extends AppCompatActivity {

    private Button editevents, editnews, editadmins;
    private Button Login_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_options);

        editevents =findViewById(R.id.Edit_events);
        editnews=findViewById(R.id.Edit_news);
        editadmins =findViewById(R.id.edit_admins);
        Login_btn =findViewById(R.id.logout);

        editevents.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                Intent intent = new Intent(Admin_options.this, Event_Admin.class);
                startActivity(intent);
            }
        });

        editnews.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                Intent intent = new Intent(Admin_options.this, News_Admin.class);
                startActivity(intent);
            }
        });

        editadmins.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                Intent intent = new Intent(Admin_options.this, Edit_Admins.class);
                startActivity(intent);
            }
        });

        Login_btn.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(Admin_options.this, Home_page.class);
                startActivity(intent);
            }
        });


       }
    }

