package com.example.trinity_college_application;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class fragment1 extends Fragment {
}



   /* RecyclerView recyclerView;
    View view;
    private final DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("");
    private final ArrayList<Eventsmodel> dataholder =new ArrayList<>();
    RecycleEventsAdapter recycleEventsAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_fragment1, container, false);
        recyclerView = view.findViewById(R.id.recyler01);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recycleEventsAdapter = new RecycleEventsAdapter(dataholder,getContext());


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot event: snapshot.child("event/2022").getChildren()){

                    if(event.hasChild("name") && event.hasChild("number") && event.hasChild("day") && event.hasChild("month") && event.hasChild("year")&& event.hasChild("class") && event.hasChild("description"))
                    {
                        final String getname= event.child("name").getValue(String.class);
                        final String getnumber= event.child("number").getValue(String.class);
                        final String getday= event.child("day").getValue(String.class);
                        final String getmonth= event.child("month").getValue(String.class);
                        final String getclass =event.child("class").getValue(String.class);
                        final String getyear= event.child("year").getValue(String.class);
                        final String getdescription= event.child("description").getValue(String.class);

                        Eventsmodel eventsmodel = new Eventsmodel(getday,getdescription, getname, getclass, getmonth, getyear, getnumber);
                        dataholder.add(eventsmodel);
                    }
                }
                recyclerView.setAdapter(new RecycleEventsAdapter(dataholder, getContext()));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

       return view;
    }
} */

    /*    Eventsmodel obj= new Eventsmodel("01","Event 1 GDSC", "02-12-2022", "Made by a lot of people" );
        dataholder.add(obj);
        Eventsmodel obj2= new Eventsmodel("02","Event 2 GDSC", "03-12-2022", "Made by a lot of people, bye" );
        dataholder.add(obj2);
        Eventsmodel obj3= new Eventsmodel("03","Event 3 GDSC", "04-12-2022", "By a lot of people, bye" );
        dataholder.add(obj3);
        Eventsmodel obj4= new Eventsmodel("40","Event 4 GDSC", "05-12-2022", "Yo, by a lot of people, bye" );
        dataholder.add(obj4);
        Eventsmodel obj5= new Eventsmodel("50","Event 5 GDSC", "06-12-2022", "Yo, by a lot of people, bye" );
        dataholder.add(obj5);
        recyclerView.setAdapter(new RecycleEventsAdapter(dataholder));
        return view;
     */


