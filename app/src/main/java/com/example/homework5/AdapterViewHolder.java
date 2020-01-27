package com.example.homework5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterViewHolder extends RecyclerView.Adapter<ViewHolder> {



    ArrayList<String> result;

    public AdapterViewHolder(){
        result = new ArrayList<>();
        result.add("answers:");


    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.view_holder,parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setText(result.get(position));
    }

    @Override
    public int getItemCount() {
        return result.size();
    }
    public void addText(String str){
        result.add(str);
        notifyDataSetChanged();
    }


}

