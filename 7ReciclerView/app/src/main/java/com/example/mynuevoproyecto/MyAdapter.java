package com.example.mynuevoproyecto;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    Context context;
    List<Item> items;

    //para el evento
    final MyAdapter.OnClickListener listener;

    public interface OnClickListener{
        void pulsar(Item item);
    }

    //public MyAdapter(Context context, List<Item> items) {
    public MyAdapter(Context context, List<Item> items, MyAdapter.OnClickListener listener) {
        this.context = context;
        this.items = items;
        //para el evento
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_layout, parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.nameR.setText((items.get(position).getName()));
        holder.imageR.setImageResource(items.get(position).getImage());

        //para el click
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    if (listener != null) {
                        listener.pulsar(items.get(position));
                    }
                }
            });

        }


    @Override
    public int getItemCount() {
        return items.size();
    }
}
