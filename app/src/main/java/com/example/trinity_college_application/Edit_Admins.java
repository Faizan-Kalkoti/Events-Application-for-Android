package com.example.trinity_college_application;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class Edit_Admins extends AppCompatActivity {

    private AppCompatButton addadmin, logout_admin;
    private TextInputLayout emailadmin, passwordadmin;
    private TextView textview_bottom3;
    private ProgressBar pg;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_admins);

        addadmin = findViewById(R.id.add_button_admin);
        logout_admin = findViewById(R.id.logout_button_admin);
        emailadmin= findViewById(R.id.email);
        passwordadmin=findViewById(R.id.passcode);
        textview_bottom3=findViewById(R.id.textView_bottom3);
        pg =findViewById(R.id.progressBar);

    }

    public void signuphere(View view) {

        pg.setVisibility(View.VISIBLE);
        String email_admin= emailadmin.getEditText().getText().toString();
        String passcode_admin =passwordadmin.getEditText().getText().toString();
        if(email_admin.isEmpty() || passcode_admin.isEmpty())
        {
            Toast.makeText(Edit_Admins.this, "Email or Password empty!", Toast.LENGTH_SHORT).show();
            textview_bottom3.setText("Please enter a valid email or Password!");

        }
        else
        {
            mAuth = FirebaseAuth.getInstance();
            mAuth.createUserWithEmailAndPassword(email_admin, passcode_admin)
                    .addOnCompleteListener(Edit_Admins.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful())
                            {
                                textview_bottom3.setText("Your are now an admin");
                                pg.setVisibility(View.INVISIBLE);
                                emailadmin.getEditText().setText("");
                                passwordadmin.getEditText().setText("");
                                Toast.makeText(getApplicationContext(),"Registered Successfully",Toast.LENGTH_LONG).show();
                            }
                            else
                            {
                                textview_bottom3.setText("Invalid email or password!");
                                pg.setVisibility(View.INVISIBLE);
                                emailadmin.getEditText().setText("");
                                passwordadmin.getEditText().setText("");
                                Toast.makeText(getApplicationContext(),"Process Error",Toast.LENGTH_LONG).show();
                            }
                        }
                    });
        }
    }
    public void logoutprocess(View view)
    {
        textview_bottom3.setText("");
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(Edit_Admins.this, Login_page.class));
    }
}