package com.example.trinity_college_application;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecycleEventsAdapter extends RecyclerView.Adapter<RecycleEventsAdapter.ViewHolder>
{
    private final ArrayList<Eventsmodel> dataholder;
    private final Context context;
    private RecyclerViewClickListener listener1;

    public RecycleEventsAdapter(ArrayList<Eventsmodel> dataholder, Context context, RecyclerViewClickListener listener1) {
        this.dataholder = dataholder;
        this.context = context;
        this.listener1= listener1;
    }
    //private RecycleNewsadapter.RecyclerViewClickListener listener;




    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.events_row, null);
        ViewHolder viewHolder= new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        Eventsmodel eventsmodel= dataholder.get(position);

        holder.class01.setText(eventsmodel.getMonth());
        holder.day01.setText(eventsmodel.getDay()+" -");
        holder.description01.setText(eventsmodel.getDescription());
        holder.month01.setText(eventsmodel.getClasses()+" -");
        holder.title01.setText(eventsmodel.getNumber());
        holder.number01.setText(eventsmodel.getTitle());
        holder.year01.setText(eventsmodel.getYear());

    }

    @Override
    public int getItemCount() {
        return dataholder.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView number01, title01, day01, month01, year01, description01, class01;
        public ViewHolder(View itemView){
            super(itemView);
            class01 =itemView.findViewById(R.id.clas);
            day01 =itemView.findViewById(R.id.day01);
            description01=itemView.findViewById(R.id.description);
            month01 =itemView.findViewById(R.id.month01);
            title01 =itemView.findViewById(R.id.name02);
            number01 =itemView.findViewById(R.id.number02);
            year01 =itemView.findViewById(R.id.year01);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener1.onClick(view, getAdapterPosition());
        }
    }

    public interface RecyclerViewClickListener {

        void onClick(View v, int position);

    }
}
