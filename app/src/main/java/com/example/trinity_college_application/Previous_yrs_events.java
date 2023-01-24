package com.example.trinity_college_application;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.Year;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;


public class Previous_yrs_events extends AppCompatActivity {
    private final DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
    private final ArrayList<Eventsmodel> dataholder =new ArrayList<>();
    RecycleEventsAdapter recycleEventsAdapter;
    private RecycleEventsAdapter.RecyclerViewClickListener listener2;
    String year00;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous_yrs_events);

        ZoneId z = ZoneId.of("Asia/Kolkata");
        LocalDate today = LocalDate.now(z);
        Year thisyear =Year.from(today);
        Year lastyear = thisyear.minusYears(1);
        String py =lastyear.toString();
        //String t =thisyear.toString();

        Toast.makeText(Previous_yrs_events.this, "-"+py+"-", Toast.LENGTH_SHORT).show();

        final RecyclerView recyclerView = findViewById(R.id.recyler03);
        setOnClickListener();

        //String ty="2022";

        recyclerView.setLayoutManager(new LinearLayoutManager(Previous_yrs_events.this));
        recycleEventsAdapter = new RecycleEventsAdapter(dataholder, Previous_yrs_events.this, listener2);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot event: snapshot.child("event/"+py).getChildren()){

                    if(event.hasChild("name") && event.hasChild("number") && event.hasChild("day") && event.hasChild("month") && event.hasChild("classes") && event.hasChild("description"))
                    {
                        final String getclass =event.child("classes").getValue(String.class);
                        final String getday= event.child("day").getValue(String.class);
                        final String getdescription= event.child("description").getValue(String.class);
                        final String getmonth= event.child("month").getValue(String.class);
                        final String getname= event.child("name").getValue(String.class);
                        final String getnumber= event.child("number").getValue(String.class);
                        final String getyear= event.child("year").getValue(String.class);


                        Eventsmodel eventsmodel = new Eventsmodel(getname, getnumber, getday, getmonth, getclass,getyear, getdescription);
                        dataholder.add(eventsmodel);
                    }
                }
                recyclerView.setAdapter(new RecycleEventsAdapter(dataholder,Previous_yrs_events.this, listener2));
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    private void setOnClickListener() {
        listener2 =new RecycleEventsAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent= new Intent(getApplicationContext(), open_events.class);
                intent.putExtra("classes", dataholder.get(position).getClasses());
                intent.putExtra("day", dataholder.get(position).getDay());
                intent.putExtra("description", dataholder.get(position).getDescription());
                intent.putExtra("month", dataholder.get(position).getMonth());
                intent.putExtra("name", dataholder.get(position).getTitle());
                intent.putExtra("number", dataholder.get(position).getNumber());
                intent.putExtra("year", dataholder.get(position).getYear());

                startActivity(intent);
            }
        };

    }
}

