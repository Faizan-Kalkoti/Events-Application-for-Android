package com.example.trinity_college_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Upcoming_events_activity extends AppCompatActivity {

    private final DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
    private final ArrayList<Eventsmodel> dataholder =new ArrayList<>();
    RecycleEventsAdapter recycleEventsAdapter;
    private RecycleEventsAdapter.RecyclerViewClickListener listener3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming_events);
        String year00;
        final RecyclerView recyclerView = findViewById(R.id.recyler02);
        setOnClickListener();
        year00 ="upcoming";

        recyclerView.setLayoutManager(new LinearLayoutManager(Upcoming_events_activity.this));
        recycleEventsAdapter = new RecycleEventsAdapter(dataholder, Upcoming_events_activity.this, listener3);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot event: snapshot.child("event/"+year00).getChildren()){

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
                recyclerView.setAdapter(new RecycleEventsAdapter(dataholder,Upcoming_events_activity.this, listener3));
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    private void setOnClickListener() {
        listener3 =new RecycleEventsAdapter.RecyclerViewClickListener() {
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