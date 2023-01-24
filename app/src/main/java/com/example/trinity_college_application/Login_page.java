package com.example.trinity_college_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import android.widget.Button;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class Login_page extends AppCompatActivity {

    private AppCompatButton loginbtn;
    private TextView txtview;
    private TextInputLayout email1, password1;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        loginbtn = findViewById(R.id.loginbtn2);
        txtview = findViewById(R.id.display_msg);
        email1 = findViewById(R.id.emailtext);
        password1 = findViewById(R.id.passwordtext);
        mAuth = FirebaseAuth.getInstance();
    }

    public void signinhere(View view) {

         String email = email1.getEditText().getText().toString();
         String password = password1.getEditText().getText().toString();

         if(email.isEmpty() || password.isEmpty())
         {
             Toast.makeText(Login_page.this, "Please Enter the email or the passcode ", Toast.LENGTH_SHORT).show();
         }
         else
         {
             mAuth.signInWithEmailAndPassword(email, password)
                     .addOnCompleteListener(Login_page.this, new OnCompleteListener<AuthResult>() {
                         @Override
                         public void onComplete(@NonNull Task<AuthResult> task) {
                             if (task.isSuccessful())
                             {
                                 email1.getEditText().setText("");
                                 password1.getEditText().setText("");
                                 txtview.setText(" ");
                                 Intent intent=new Intent(Login_page.this, Admin_options.class);
                                 intent.putExtra("email",mAuth.getCurrentUser().getEmail());
                                 intent.putExtra("uid",mAuth.getCurrentUser().getUid());
                                 startActivity(intent);
                             } else
                             {
                                 email1.getEditText().setText("");
                                 password1.getEditText().setText("");
                                 Toast.makeText(getApplicationContext(),"Invalid email/password",Toast.LENGTH_LONG).show();
                                 txtview.setText("Please enter a valid Email or Password!");
                             }

                             // ...
                         }
                     });
         }
    }
}
