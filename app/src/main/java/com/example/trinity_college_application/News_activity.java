package com.example.trinity_college_application;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class News_activity extends AppCompatActivity {


RecyclerView recyclerView;
RecycleNewsadapter recycleNewsadapter;
private final DatabaseReference databaseReference =FirebaseDatabase.getInstance().getReference("");
private final ArrayList<Newsmodel> list = new ArrayList<>();
private RecycleNewsadapter.RecyclerViewClickListener listener;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        setOnClickLitener();
        recyclerView = findViewById(R.id.newsrecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(News_activity.this));
        recycleNewsadapter = new RecycleNewsadapter(this, list, listener);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot news: snapshot.child("news").getChildren()){

                    if(news.hasChild("name") && news.hasChild("number") && news.hasChild("date") && news.hasChild("description"))
                    {
                        final String getname= news.child("name").getValue(String.class);
                        final String getnumber= news.child("number").getValue(String.class);
                        final String getdate= news.child("date").getValue(String.class);
                        final String getdescription= news.child("description").getValue(String.class);

                        Newsmodel newsmodel = new Newsmodel(getdate,getdescription, getname, getnumber);
                        list.add(newsmodel);
                    }
                }
                recyclerView.setAdapter(new RecycleNewsadapter(News_activity.this, list, listener));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }

    private void setOnClickLitener() {
        listener=new RecycleNewsadapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent= new Intent(getApplicationContext(), open_news.class);
                intent.putExtra("name", list.get(position).getName());
                intent.putExtra("number", list.get(position).getNumber());
                intent.putExtra("date", list.get(position).getDate());
                intent.putExtra("description", list.get(position).getDescription());
                startActivity(intent);
            }
        };
        }

}

