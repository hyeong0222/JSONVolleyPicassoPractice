package com.example.jsonvolleypicassopractice;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    List<Categories> categoriesList;

    public MyAdapter(List<Categories> categoriesList) {
        this.categoriesList = categoriesList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View myView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent,false);

        return new MyViewHolder(myView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
        Categories categories = categoriesList.get(position);
        myViewHolder.textViewID.setText(categories.getId());
        myViewHolder.textViewName.setText(categories.getName());

        Picasso.get().load(categories.getImage_url()).fit().into(myViewHolder.imageView);

    }

    @Override
    public int getItemCount() {
        return categoriesList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textViewID, textViewName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textViewID = itemView.findViewById(R.id.idTextView);
            textViewName = itemView.findViewById(R.id.nameTextView);
        }
    }
}
