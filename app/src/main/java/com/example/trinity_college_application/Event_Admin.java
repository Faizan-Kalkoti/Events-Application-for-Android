package com.example.trinity_college_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Event_Admin extends AppCompatActivity {

    private Button pastbtn, upcomingbtn;
    private Button add_button, deletebutton;
    private EditText textname, class_yr;
    private EditText  textnumber, text_day, text_month, text_year, text_decription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_admin);

    }

    public void enterevents(View view) {



        add_button= findViewById(R.id.Add_button);
        deletebutton= findViewById(R.id.Delete_button);

        textnumber= findViewById(R.id.TextNumber);
        textname= findViewById(R.id.TextName);
        text_decription= findViewById(R.id.description);
      //  multiline = findViewById(R.id.TextMultiLine1);
        class_yr =findViewById(R.id.Class_year);
        text_day=findViewById(R.id.DayDate);
        text_year=findViewById(R.id.YearDate);
        text_month=findViewById(R.id.MonthDate);

        String number = textnumber.getText().toString().trim();
        String name = textname.getText().toString().trim();
        String description = text_decription.getText().toString().trim();
        String classes = class_yr.getText().toString().trim();
        String day = text_day.getText().toString().trim();
        String month = text_month.getText().toString().trim();
        String year = text_year.getText().toString().trim();

        if(year.isEmpty() || number.isEmpty())
        {
            Toast.makeText(Event_Admin.this, "Please enter year and Event number\n    to add events!", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Events_Database_inserted obj= new Events_Database_inserted(name, description, classes, month ,day, year, number);
            FirebaseDatabase db =FirebaseDatabase.getInstance();
            DatabaseReference node = db.getReference("event/"+year);
            node.child(number).setValue(obj);

            textnumber.setText("");
            textname.setText("");
            // multiline.setText("");
            class_yr.setText("");
            text_day.setText("");
            text_year.setText("");
            text_month.setText("");
            text_decription.setText("");
            Toast.makeText(Event_Admin.this, "Values inserted successfully", Toast.LENGTH_SHORT).show();
        }
    }
    public void delete_events(View view) {

        textnumber=findViewById(R.id.TextNumber);
        text_year=findViewById(R.id.YearDate);

        String number = textnumber.getText().toString().trim();
        String year = text_year.getText().toString().trim();
        if(number.isEmpty() || year.isEmpty())
        {
            Toast.makeText(Event_Admin.this, "Please enter the event number\n and year to delete events!", Toast.LENGTH_SHORT).show();
        }
        else{
            DatabaseReference events_num = FirebaseDatabase.getInstance().getReference("event/"+year).child(number);
            events_num.removeValue();
            Toast.makeText(Event_Admin.this, "Events Deleted!", Toast.LENGTH_SHORT).show();
        }
    }
}
