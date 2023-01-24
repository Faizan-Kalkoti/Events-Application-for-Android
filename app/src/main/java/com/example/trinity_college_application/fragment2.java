package com.example.trinity_college_application;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class fragment2 extends Fragment {

    RecyclerView recyclerView;
    View view;
    ArrayList<Eventsmodel> dataholder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_2, container, false);
        recyclerView = view.findViewById(R.id.recyler02);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

      /*  dataholder=new ArrayList<>();
        Eventsmodel obj= new Eventsmodel("01","Event 1 GDSC", "02-12-2022", month, "Made by a lot of people" );
        dataholder.add(obj);
        Eventsmodel obj2= new Eventsmodel("02","Event 2 GDSC", "03-12-2022", month, "Made by a lot of people, bye" );
        dataholder.add(obj2);
        Eventsmodel obj3= new Eventsmodel("03","Event 3 GDSC", "04-12-2022", month, "By a lot of people, bye" );
        dataholder.add(obj3);
        Eventsmodel obj4= new Eventsmodel("40","Event 4 GDSC", "05-12-2022", month, "Yo, by a lot of people, bye" );
        dataholder.add(obj4);
        Eventsmodel obj5= new Eventsmodel("50","Event 5 GDSC", "06-12-2022", month, "Yo, by a lot of people, bye" );
        dataholder.add(obj5);
        recyclerView.setAdapter(new RecycleEventsAdapter(dataholder, (fragment1.this)));


       */
        return view;
    }
}