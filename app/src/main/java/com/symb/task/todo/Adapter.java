package com.symb.task.todo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    private Context context;
    private static List<Todo_task> NotesList;


    public Adapter(Context context, List<Todo_task> NotesList){
        this.context=context;
        this.NotesList=NotesList;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemview;
        LayoutInflater minflator= LayoutInflater.from(context);
        itemview=minflator.inflate(R.layout.custom_grid,viewGroup,false);
        return new MyViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.note.setText(NotesList.get(position).getContent());
        holder.date.setText(NotesList.get(position).getDate());

    }

    @Override
    public int getItemCount() {
        return NotesList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView note,date;



        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            note=(TextView) itemView.findViewById(R.id.note);
            date=(TextView) itemView.findViewById(R.id.date);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(v.getContext(),Details.class);
                    i.putExtra("ID",NotesList.get(getAdapterPosition()).getId());
                    v.getContext().startActivity(i);
                }
            });
        }
    }
}
