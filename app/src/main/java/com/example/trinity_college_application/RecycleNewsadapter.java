package com.example.trinity_college_application;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class RecycleNewsadapter extends RecyclerView.Adapter<RecycleNewsadapter.Myviewholder> {

    private final Context context;
    private final ArrayList<Newsmodel> list;
    private RecyclerViewClickListener listener;

    public RecycleNewsadapter(Context context, ArrayList<Newsmodel> list, RecyclerViewClickListener listener) {
        this.context = context;
        this.list = list;
        this.listener =listener;
    }

    @NonNull
    @Override
    public RecycleNewsadapter.Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.news_row, null);
        return new Myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleNewsadapter.Myviewholder holder, int position) {
        Newsmodel newsmodel = list.get(position);
        holder.name1.setText(newsmodel.getName());
        holder.number1.setText((newsmodel.getNumber()));
        holder.description1.setText(newsmodel.getDescription());
        holder.date1.setText(newsmodel.getDate());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Myviewholder extends RecyclerView.ViewHolder implements View.OnClickListener{

       private final TextView number1, date1, name1, description1;
        public Myviewholder(@NonNull View itemView) {
            super(itemView);
            number1= itemView.findViewById(R.id.number01);
            date1 =itemView.findViewById(R.id.date01);
            name1 =itemView.findViewById(R.id.name01);
            description1 =itemView.findViewById(R.id.description01);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onClick(view, getAdapterPosition());
        }
    }

    public interface RecyclerViewClickListener{
        void onClick(View v, int position);
    }
}