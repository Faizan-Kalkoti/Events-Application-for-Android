package com.example.trinity_college_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class News_Admin extends AppCompatActivity {

    private Button add_button, deletebutton;
    private EditText textnumber, textname, textmultiline, textdate;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_admin);
        add_button=findViewById(R.id.add_button_news);
        deletebutton=findViewById(R.id.delete_button_news);

        textnumber=findViewById(R.id.Newsnumber);
        textname=findViewById(R.id.passcode);

        String number1 = textnumber.getText().toString().trim();


    }


    public void enternews(View view) {

        textnumber=findViewById(R.id.Newsnumber);
        textname=findViewById(R.id.passcode);
        textmultiline=findViewById(R.id.Newsdescrption);
        textdate=findViewById(R.id.Newsdate);

        String number = textnumber.getText().toString().trim();
        String name =textname.getText().toString().trim();
        String description = textmultiline.getText().toString().trim();
        String date = textdate.getText().toString().trim();

        if(number.isEmpty())
        {
            Toast.makeText(News_Admin.this, "Please enter the news number \nto add the news!", Toast.LENGTH_SHORT).show();
        }
        else
        {
            News_Database_inserted obj1= new News_Database_inserted(name, description, date, number);
            FirebaseDatabase db =FirebaseDatabase.getInstance();
            DatabaseReference node = db.getReference("news");
            node.child(number).setValue(obj1);

            textdate.setText("");
            textnumber.setText("");
            textmultiline.setText("");
            textname.setText("");

            Toast.makeText(News_Admin.this, "Values inserted successfully", Toast.LENGTH_SHORT).show();

        }
    }


    public void deletenews(View view) {

        textnumber=findViewById(R.id.Newsnumber);
        String number = textnumber.getText().toString().trim();
        if(number.isEmpty())
        {
            Toast.makeText(News_Admin.this, "Please enter the news number \n to delete news!", Toast.LENGTH_SHORT).show();
        }
        else{
            DatabaseReference news_num = FirebaseDatabase.getInstance().getReference("news").child(number);
            news_num.removeValue();
            Toast.makeText(News_Admin.this, "News Deleted!", Toast.LENGTH_SHORT).show();
        }
    }
}
